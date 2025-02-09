package com.example.certi.veri.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.certi.veri.entity.Certificate;
import com.example.certi.veri.entity.User;
import com.example.certi.veri.services.AdminServiceImple;
import com.example.certi.veri.services.CertificateServiceImplentation;
import com.example.certi.veri.services.UserServiceImplementation;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

	@Autowired
	AdminServiceImple aserv;
	
	@Autowired
	CertificateServiceImplentation cserv;
	
	@Autowired
	UserServiceImplementation userv;
	
	
	
	//All Admin service
	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password) {
		return aserv.signIn(email, password);
	}
	
	//All certificates services
	@PostMapping("/addCerti")
	public ResponseEntity<String> addCertificate(@RequestBody Certificate certi) {
		if(cserv.certiExist(certi.getCertificateId())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Certificate already exist");
		}
		cserv.addCertificate(certi);
		return ResponseEntity.status(HttpStatus.CREATED).body("Certificate has been added");
	}
	
	
	@GetMapping("/getCerti/{id}")
	public ResponseEntity<Certificate> getCertificateById(@PathVariable String id) {
		Optional<Certificate> certi = cserv.getCertificateById(id);
		return certi.map(ResponseEntity::ok)
				.orElseGet(()->ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/getCertis")
	public ResponseEntity<List<Certificate>> getAllCertificate(){
		List<Certificate> certis= cserv.getAllCertificate();
		if(certis.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(certis);
	}

	@DeleteMapping("/deleteCerti/{id}")
	public ResponseEntity<Void> deleteCertificate(@PathVariable String id) {
		if(cserv.certiExist(id)) {
			cserv.deleteCertificate(id);
			return ResponseEntity.noContent().build(); //noContent means status 204
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //Not_Found means status 404
		}
	}
	
	
	//All User Service
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> users = userv.getAllUser();
		if(users.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable String id){
		Optional<User> user = userv.getUserById(id);
		return user.map(ResponseEntity::ok)
				.orElseGet(()->ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id){
		if(userv.userExist(id)) {
			userv.deleteUser(id);
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
}
