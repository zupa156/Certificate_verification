package com.example.certi.veri.services;

import java.util.List;

import com.example.certi.veri.dto.VerificationDto;
import com.example.certi.veri.entity.Certificate;
import com.example.certi.veri.entity.User;
import com.example.certi.veri.entity.Verification;

public interface VerificationService {
	public String addVerification(Verification veri);
	List<Verification> getAllVerification();
	Certificate verifyCertificate(VerificationDto dto);
}
