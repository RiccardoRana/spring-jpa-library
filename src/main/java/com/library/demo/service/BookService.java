package com.library.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.demo.model.Author;
import com.library.demo.model.Book;
import com.library.demo.repository.AuthorRepository;
import com.library.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private  BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public List<Book> getBooksByTitle(String Title) {
		return bookRepository.findByTitleContainingIgnoreCase(Title);
	}

	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	@Transactional
	public Book create(Book book) {
		for(Author author:book.getAuthors())
			authorRepository.save(author);
		return bookRepository.save(book);
	}
	
	public Optional<Book> findById(int bookId) {
		return bookRepository.findById(bookId);
	}

   
    





}
