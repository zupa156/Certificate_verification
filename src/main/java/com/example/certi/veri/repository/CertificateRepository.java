package com.example.certi.veri.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.certi.veri.entity.Certificate;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, String>{
	  Optional<Certificate> findByCertificateIdAndStudentNameAndPrn(String certificateId, String studentName, int prn);
}
