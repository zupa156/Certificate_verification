package com.example.certi.veri.services;

import java.util.List;
import java.util.Optional;

import com.example.certi.veri.entity.User;

public interface UserService {
	public String addUser(User user);
	public String deleteUser(String userId);
	boolean userExist(String id);
	public boolean emailExists(String email);
	Optional<User> getUserById(String id);
	List<User> getAllUser();
	public String login(String email, String password);
	
}
