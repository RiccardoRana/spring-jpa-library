package com.library.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.library.demo.model.User;
import com.library.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/list")
	public ResponseEntity<Object> getElenco() {
		try {

			List<User> users = new ArrayList<User>();
			userService.getAllUsers().forEach(users::add);
			return new ResponseEntity<Object>(users, HttpStatus.OK);
		}

		catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/create")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {

		if (userService.checkPassword(user)) {
			return new ResponseEntity<Object>(userService.createUser(user), HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>("Password non valida!", HttpStatus.FORBIDDEN);

	}
}
