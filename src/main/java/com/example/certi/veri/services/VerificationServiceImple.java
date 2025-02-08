package com.example.certi.veri.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.certi.veri.entity.Certificate;
import com.example.certi.veri.entity.Verification;
import com.example.certi.veri.repository.CertificateRepository;
import com.example.certi.veri.repository.VerificationRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class VerificationServiceImple implements VerificationService{

	@Autowired
	VerificationRepository vrep;
	
	@Autowired
	CertificateRepository crep;
	
	//Verification details will be displayed on the Admin dashboard
	@Override
	public List<Verification> getAllVerification() {
		return vrep.findAll();
	}

	@Override
	public Certificate verifyCertificate(String certificateId, String studentName, int prn) {
		Optional<Certificate> certiOpt = crep.findByCertificateIdAndStudentNameAndPrn(certificateId, studentName, prn);
		if(certiOpt.isPresent()) {
			Certificate certi = certiOpt.get();
			
			Verification veri = new Verification();
			veri.setStatus("Verified");
			veri.setType("Manual");
			veri.setVerifiedDate(new Date());
			veri.setCertificate(certi);
			vrep.save(veri);
			
			return certi;
		}else {
			return null;
		}
		
	}

	@Override
	public String addVerification(Verification veri) {
		vrep.save(veri);
		return "Verification done";
	}

}
