package com.example.certi.veri.entity;



import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "verification")
public class Verification {
	@Id
	@Column(name="verificationId", length=20)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int verificationId;

	@Column(name="status", nullable=false)
	private String status;

	@Column(name="type")
	private String Type;

	@Temporal(TemporalType.DATE)
	private Date verifiedDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="certificateId", referencedColumnName = "certificateId") //Foreign key
	private Certificate certificate;
	
	@OneToOne(mappedBy = "verification", fetch = FetchType.EAGER)
    private Transaction transaction;
}
