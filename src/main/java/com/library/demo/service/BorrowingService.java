package com.library.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.demo.model.Book;
import com.library.demo.model.Borrowing;
import com.library.demo.repository.BookRepository;
import com.library.demo.repository.BorrowingRepository;

import Exceptions.NotEnougthCopiesException;

@Service
public class BorrowingService {

   @Autowired
   private BorrowingRepository borrowingRepository;
   

	@Autowired
	private BookRepository bookRepository;
	
	@Transactional
	public Borrowing create(Borrowing borrowing) throws  NotEnougthCopiesException {
		Book bookToBorrow=borrowing.getBook();
		if (bookToBorrow.getAvailableCopies()>0)
		{
			bookToBorrow.setAvailableCopies(
					bookToBorrow.getAvailableCopies()-1);
			borrowing.setStartDate(LocalDate.now());
			bookRepository.save(bookToBorrow);
			return borrowingRepository.save(borrowing);
		} else
			throw new NotEnougthCopiesException(bookToBorrow);
		
	}
	
	@Transactional
	public Borrowing close(Borrowing borrowing) {
		Book bookToBorrow=borrowing.getBook();
		bookToBorrow.setAvailableCopies(
				bookToBorrow.getAvailableCopies()+1);
		borrowing.setEndDate(LocalDate.now());
		bookRepository.save(bookToBorrow);
		return borrowingRepository.save(borrowing);
	}
	
	public Optional<Borrowing> findById(int id) {
		return borrowingRepository.findById(id);
	}
   
//   public Borrowing create(Borrowing borrowing) {
//	   borrowing.getBook().setAvailableCopies(borrowing.getBook().getAvailableCopies());
//	   return borrowingRepository.save(borrowing);
//   }
   
   public List<Borrowing> list() {
		return borrowingRepository.findAll();
	}


}
