package com.cg.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_hobbies")
public class Hobbies {

	@Id
	@UniqueElements
	@Column(nullable = false)
	private String rollNumber;
	private String hobby;
	
}
