package com.example.certi.veri.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;
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
//	@Version
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", length=20, nullable = false)
	private String userId;

	@Column(name = "address", length=255, nullable = false)
	private String address;

	@Column(name = "designation", length=50, nullable=false)
	private String designation;

	@Column(name = "email", length=50, nullable=false)
	private String email;

	@Column(name = "organization", length=50, nullable=false)
	private String organization;

	@Column(name = "phoneNumber", length=20, nullable=false)
	private String phone_number;

	@Column(name = "reasonForVerification", length=100, nullable=false)
	private String reasonForVerification;

	@Column(name = "typeOfUser", length=20, nullable=false)
	private String typeOfUser;

	@Column(name = "name", length=50, nullable=false)
	private String name;

	@Column(name = "userPassword", length=68, nullable=false)
	private String user_password; 

	@Transient
	@OneToMany(mappedBy = "user")
	private Map<String, Transaction> transactios=new HashMap<String, Transaction>();

}
