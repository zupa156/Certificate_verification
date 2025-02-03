package com.example.certi.veri.services;

import java.util.Optional;

import com.example.certi.veri.entity.Certificate;

public interface CertificateService {
	String addCertificate(Certificate certi);
	Optional<Certificate> getCertificateById(String id);
	void deleteCertificate(String id);
}
