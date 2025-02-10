package com.example.certi.veri.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.certi.veri.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmailAndUserPassword(String userName,String password);
	public User findByEmail(String email);
}