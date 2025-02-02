package com.example.certi.veri.entity;



import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "verification")
public class Verification {
	@Id
	@Column(name="VerificationId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int verificationId;

	@Column(name="status")
	private String status;

	@Column(name="Type")
	private String Type;

	@Temporal(TemporalType.DATE)
	private Date verifiedDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="certificateId", referencedColumnName = "certificateId")
	private Certificate certificate;
	
	@OneToOne(mappedBy = "verification")
    private Transaction transaction;
}
