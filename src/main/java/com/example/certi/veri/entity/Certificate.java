package com.example.certi.veri.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "certificate")
public class Certificate {
	
	@Id
	@Column(name = "CertificateId", length=20, nullable=false)
	private String certificateId;

	@Column(name = "Completion_Date")
	@Temporal(TemporalType.DATE)
	private Date completion_Date;

	@Column(name = "Course_Name", length=50, nullable=false)
	private String course_Name;

	@Column(name = "Enrollment_Date", length=50, nullable=false)
	@Temporal(TemporalType.DATE)
	private Date enrollment_Date;

	@Column(name = "Grade", length=3, nullable=false)
	private String grade;

	

	@Column(name = "PRN", nullable=false)
	private int PRN;

	@Column(name = "Student_Name", length=50, nullable=false)
	private String student_Name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MarksId", referencedColumnName = "MarksId")
	private Mark marks;

	@OneToOne(mappedBy = "certificate")
	private Verification verification;

}
