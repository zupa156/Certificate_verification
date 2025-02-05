package com.example.certi.veri.services;

import java.util.List;
import java.util.Optional;

import com.example.certi.veri.entity.Certificate;
import com.example.certi.veri.entity.User;

public interface CertificateService {
	String addCertificate(Certificate certi);
	Optional<Certificate> getCertificateById(String id);
	List<Certificate> getAllCertificate();
	boolean certiExist(String id);
	void deleteCertificate(String id);
}
