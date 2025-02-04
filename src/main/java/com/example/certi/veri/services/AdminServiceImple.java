package com.example.certi.veri.services;

import com.example.certi.veri.entity.Admin;

public class AdminServiceImple implements AdminService {

	//Hard-coding right now later will change it
	
	
	@Override
	public String insertAdmin(Admin ad) {
		return "Admin "+ad.getAdminUserName()+" inserted successfully";
	}

	@Override
	public String signIn(String username, String password) {
		username = "admin";
		password = "admin@123";
		Admin ad = new Admin();
		if(ad.getAdminUserName().equals(username) && ad.getAdminPassword().equals(password)) {
			return "Sign-in successful for user";
		}else {
			return "Sign-in failed: Invalid username or password.";
	
		}
	}
}
