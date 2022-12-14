package com.library.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.demo.model.Borrowing;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Integer> {

	

}
