package com.example.certi.veri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.certi.veri.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	public User findByEmail(String email);
}
