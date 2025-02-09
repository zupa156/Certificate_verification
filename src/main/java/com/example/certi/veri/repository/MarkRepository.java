package com.example.certi.veri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.certi.veri.entity.Mark;

@Repository
public interface MarkRepository extends JpaRepository<Mark, String>{

}
