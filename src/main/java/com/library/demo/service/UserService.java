package com.library.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.demo.model.User;
import com.library.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Optional<User> findById(int userId) {
		return userRepository.findById(userId);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public boolean checkPassword(User user) {
		String password = user.getPassword();
		boolean valid = false;
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);

			if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9')) {
				
				valid = true;

			} else {
				valid = false;
			}

		}
		return valid;
	}

}
