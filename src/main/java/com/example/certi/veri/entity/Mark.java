package com.example.certi.veri.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="marks")
public class Mark {
	
	@Id
	@Column(name = "marksId", length=20, nullable=false)
	private String marksId;

	@Column(name = "grade", nullable=false)
	private String grade;

	@Column(name = "maximumMarks", nullable=false)
	private int maximumMarks;

	@Column(name = "obtainedMarks", nullable=false)
	private int obtainedMarks;

	@Column(name = "percentage", nullable=false)
	private float percentage;

	@OneToOne(mappedBy = "marks", fetch = FetchType.EAGER)
	private Certificate certificate;

	
}
