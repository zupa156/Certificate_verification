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

	@Column(name = "Address")
	private String address;

	@Column(name = "Designation")
	private String designation;

	@Column(name = "email")
	private String email;

	@Column(name = "organization")
	private String organization;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@Column(name = "ReasonForVerification")
	private String reasonForVerification;

	@Column(name = "TypeOfUser")
	private String typeOfUser;

	@Column(name = "UserName")
	private String userName;

	@Column(name = "UserPassword")
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Transaction> transaction;

}
