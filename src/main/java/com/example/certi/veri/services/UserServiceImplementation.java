package com.example.certi.veri.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.certi.veri.entity.User;
import com.example.certi.veri.repository.UserRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UserServiceImplementation implements UserService{

	@Autowired
	UserRepository urep;
	
	
	@Override
	public String addUser(User user) {
		//user.setUserId();
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
		if(user!= null && user.getUser_password().equals(password)) {
			return "Login successful";
		}else {
			return "Invalid email or password";
		}	
	}

	@Override
	public String deleteUser(String userId) {
		if(urep.existsById(userId)) {
			urep.deleteById(userId);
			return "User with ID "+ userId+" has been deleted";
		}
		else {
			return "User with ID "+userId+" does not exist";
		}
	}

	@Override
	public Optional<User> getUserById(String id) {
		
		return urep.findById(id);
	}

	@Override
	public List<User> getAllUser() {
		return urep.findAll();
	}

	@Override
	public boolean userExist(String id) {
		return urep.existsById(id);
	}

}
