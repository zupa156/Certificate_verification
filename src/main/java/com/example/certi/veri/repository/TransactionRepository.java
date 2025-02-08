package com.example.certi.veri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.certi.veri.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	Transaction findByOrderId(String orderId);

}
