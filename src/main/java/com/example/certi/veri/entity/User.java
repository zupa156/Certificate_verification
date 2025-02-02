package com.example.certi.veri.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "UserId")
	private String userId;

	@Column(name = "Address", length=255)
	private String address;

	@Column(name = "Designation", length=50)
	private String designation;

	@Column(name = "email", length=50)
	private String email;

	@Column(name = "organization", length=50)
	private String organization;

	@Column(name = "PhoneNumber", length=20)
	private String phoneNumber;

	@Column(name = "ReasonForVerification", length=100)
	private String reasonForVerification;

	@Column(name = "TypeOfUser", length=20)
	private String typeOfUser;

	@Column(name = "UserName", length=50)
	private String userName;

	@Column(name = "UserPassword", length=68)
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Transaction> transaction;

}
