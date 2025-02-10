package com.example.certi.veri.services;

import java.util.List;
import java.util.Optional;

import com.example.certi.veri.dto.LogIndto;
import com.example.certi.veri.entity.User;

public interface UserService {
	public String addUser(User user);
	public String deleteUser(Long userId);
	boolean userExist(Long id);
	public boolean emailExists(String email);
	Optional<User> getUserById(Long id);
	List<User> getAllUser();
	User login(LogIndto dto );
	
}
