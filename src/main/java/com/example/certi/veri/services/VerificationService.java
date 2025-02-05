package com.example.certi.veri.services;

import java.util.List;

import com.example.certi.veri.entity.Certificate;
import com.example.certi.veri.entity.Verification;

public interface VerificationService {
	List<Verification> getAllVerification();
	Certificate verifyCertificate(String certificateId, String studentName, int prn);
}
