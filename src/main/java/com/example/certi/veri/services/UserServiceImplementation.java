package com.example.certi.veri.services;

import org.springframework.stereotype.Service;

import com.example.certi.veri.entity.User;
import com.example.certi.veri.repository.UserRepository;


@Service
public class UserServiceImplementation implements UserService{

	UserRepository urep;
	@Override
	public String addUser(User user) {
		urep.save(user);
		return "User is created and saved";
	}

	@Override
	public boolean emailExists(String email) {
		if(urep.findByEmail(email)==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String login(String email, String password) {
		User user = urep.findByEmail(email);
		if(user!= null && user.getPassword().equals(password)) {
			return "Login successful";
		}else {
			return "Invalid email or password";
		}	
	}

}
