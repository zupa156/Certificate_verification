package com.example.certi.veri.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
//import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "certificate")
public class Certificate {
	
	@Id
	@Column(name = "certificateId", length=20, nullable=false)
	private String certificateId;

	@Column(name = "completion_Date")
	@Temporal(TemporalType.DATE)
	private Date completion_Date;

	@Column(name = "course_Name", length=50, nullable=false)
	private String course_Name;

	@Column(name = "enrollment_Date", length=50, nullable=false)
	@Temporal(TemporalType.DATE)
	private Date enrollment_Date;

	@Column(name = "grade", length=3, nullable=false)
	private String grade;

	@Column(name = "prn", nullable=false)
	private int prn;

	@Column(name = "student_Name", length=50, nullable=false)
	private String student_Name;
	
	//@Transient
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "marksId", referencedColumnName = "marksId")
	private Mark marks;

	@OneToMany(mappedBy = "certificate", fetch = FetchType.EAGER)
	private List<Verification> verification;

}
