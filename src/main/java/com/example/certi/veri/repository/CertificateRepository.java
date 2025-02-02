package com.example.certi.veri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.certi.veri.entity.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, String>{

}
