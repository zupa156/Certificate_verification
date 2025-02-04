package com.example.certi.veri.services;

import com.example.certi.veri.entity.Admin;

public interface AdminService {
	String insertAdmin(Admin ad);
	String signIn(String username, String passowrd);
}
