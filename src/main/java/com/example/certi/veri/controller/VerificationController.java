package com.example.certi.veri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.certi.veri.entity.Certificate;
import com.example.certi.veri.services.VerificationServiceImple;

@RestController
@RequestMapping("/api/verification")
public class VerificationController {

	@Autowired
	VerificationServiceImple vserv;
	
	@GetMapping("/verify")
	public ResponseEntity<?> verifyCerti(@RequestParam String id, @RequestParam String studentName, @RequestParam int prn ){
		Certificate certi = vserv.verifyCertificate(id, studentName, prn);
		if(certi !=null) {
			return ResponseEntity.ok(certi);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Certificate not found or the details do not match");
		}
	}
}
