package com.example.certi.veri.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	@Column(name="transactionId", length=20)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;

	@Column(name="amount", nullable=false)
	private float amount;

	@Column(name="description", length=50)
	private String description;

	@Column(name="transactionDate", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date transactionDate;


	//@Enumerated(EnumType.STRING)
	@Column(name="transactionType", length=50)
	private String transactionType;

	
//	@Column(name="UserId",table="transaction")
//	private String userId;

	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "userId") //Foreign key
	private User user;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "verificationId", referencedColumnName = "verificationId") //Foreign key
	 private Verification verification;

}
