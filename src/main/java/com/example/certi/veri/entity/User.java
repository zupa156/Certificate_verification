package com.example.certi.veri.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", length = 20)
    private Long userId;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "designation", length = 50, nullable = false)
    private String designation;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "organization", length = 50, nullable = false)
    private String organization;

    @Column(name = "phoneNumber", length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "reasonForVerification", length = 100, nullable = false)
    private String reasonForVerification;

    @Column(name = "typeOfUser", length = 20, nullable = false)
    private String typeOfUser;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "userPassword", length = 68, nullable = false)
    private String userPassword;

    @Transient
    @OneToMany(mappedBy = "user")
    private Map<String, Transaction> transactions = new HashMap<>();

    
    
	public User(Long userId, String address, String designation, String email, String organization, String phoneNumber,
			String reasonForVerification, String typeOfUser, String name, String userPassword) {
		super();
		this.userId = userId;
		this.address = address;
		this.designation = designation;
		this.email = email;
		this.organization = organization;
		this.phoneNumber = phoneNumber;
		this.reasonForVerification = reasonForVerification;
		this.typeOfUser = typeOfUser;
		this.name = name;
		this.userPassword = userPassword;
	}
    
	
    
    
}