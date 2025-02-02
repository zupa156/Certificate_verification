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
	private int VerificationId;

	@Column(name="status")
	private String Status;

	@Column(name="Type")
	private String Type;

	@Temporal(TemporalType.DATE)
	private Date VerifiedDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="certificateId", referencedColumnName = "certificateId")
	private Certificate certificate;
	
	@OneToOne(mappedBy = "verification")
    private Transaction transaction;
}
