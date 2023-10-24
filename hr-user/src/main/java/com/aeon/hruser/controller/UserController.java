package com.aeon.hruser.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aeon.hruser.entity.User;
import com.aeon.hruser.repository.UserRepository;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userRepository.findById(id).get();
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}	

	@GetMapping(value = "/search")
	public ResponseEntity<User> findById(@RequestParam String email) {
		User user = userRepository.findByEmail(email);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
