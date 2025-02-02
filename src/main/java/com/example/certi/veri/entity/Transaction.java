package com.example.certi.veri.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@Column(name="TransactionId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int TransactionId;

	@Column(name="amount")
	private float amount;

	@Column(name="Description", length=50)
	private String Description;

	@Column(name="TransactionDate")
	@Temporal(TemporalType.DATE)
	private Date TransactionDate;


	@Column(name="TransactionType", length=50)
	private String TransactionType;

	
//	@Column(name="UserId",table="transaction")
//	private String userId;

	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "verificationId", referencedColumnName = "verificationId")
	 private Verification verification;

}
