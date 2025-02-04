package com.example.certi.veri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.certi.veri.entity.User;
import com.example.certi.veri.services.UserServiceImplementation;

@RestController
@RequestMapping("/api/certi/users")
public class UsersController {
	
	@Autowired
	UserServiceImplementation userv;
	
	
	//Registration of the user
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		if(userv.emailExists(user.getEmail())){
			return "Email already exist. please use different email.";
		}
		try {
			userv.addUser(user);
		}catch(Exception e) {
			return "Got an exception";
		}
		return "Success";
	}
	
	
	//Login of the user
	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password) {
		return userv.login(email, password);
	}
}
