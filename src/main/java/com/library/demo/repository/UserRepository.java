package com.library.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.library.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
