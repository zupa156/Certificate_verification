package com.example.certi.veri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.certi.veri.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	public User findByEmail(String email);
}
