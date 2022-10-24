package com.library.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.library.demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	// Operazioni Crud
	public List<Book> findByTitleContainingIgnoreCase(String Titolo);

}
