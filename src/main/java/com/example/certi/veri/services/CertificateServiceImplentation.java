package com.example.certi.veri.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.certi.veri.entity.Certificate;
import com.example.certi.veri.repository.CertificateRepository;

public class CertificateServiceImplentation implements CertificateService {

	@Autowired
	CertificateRepository crep;
	
	@Override
	public String addCertificate(Certificate certi) {
		crep.save(certi);
		return "Certificate has been added";
	}

	@Override
	public Optional<Certificate> getCertificateById(String id) {
		return crep.findById(id);
	}

	@Override
	public void deleteCertificate(String id) {
		crep.deleteById(id);
	}

}
