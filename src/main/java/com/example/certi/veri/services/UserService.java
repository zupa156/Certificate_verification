package com.example.certi.veri.services;

import com.example.certi.veri.entity.User;

public interface UserService {
	public String addUser(User user);
	public String deleteUser(String userId);
	public boolean emailExists(String email);
	public String login(String email, String password);
	
}
