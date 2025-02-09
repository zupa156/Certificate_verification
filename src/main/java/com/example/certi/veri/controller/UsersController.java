package com.example.certi.veri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.certi.veri.entity.User;
import com.example.certi.veri.services.UserServiceImplementation;

@RestController
@RequestMapping("/api/certi/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UsersController {
	
	@Autowired
	UserServiceImplementation userv;
	
	
	//Registration of the user
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
	    // Check if the email already exists
	    if (userv.emailExists(user.getEmail())) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists. Please use a different email.");
	    }

	    try {
	        // Add the user
	        userv.addUser(user);
	        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully!");
	    } catch (Exception e) {
	        // Handle exceptions
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during registration: " + e.getMessage());
	    }
	}
	
	
	//Login of the user
	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password) {
		return userv.login(email, password);
	}
}
