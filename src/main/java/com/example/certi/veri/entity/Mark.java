package com.example.certi.veri.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	@Column(name = "MarksId", length=50, nullable=false)
	private String marksId;

	@Column(name = "Grade")
	private String grade;

	@Column(name = "MaximumMarks")
	private int maximumMarks;

	@Column(name = "ObtainedMarks")
	private int obtainedMarks;

	@Column(name = "Percentage")
	private float percentage;

	@OneToOne(mappedBy = "marks")
	private Certificate certificate;

	
}
