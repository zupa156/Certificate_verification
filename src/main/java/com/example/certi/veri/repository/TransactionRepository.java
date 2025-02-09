package com.example.certi.veri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.certi.veri.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	Transaction findByOrderId(String orderId);

}
