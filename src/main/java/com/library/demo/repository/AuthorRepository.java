package com.library.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.demo.model.Author;


public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
