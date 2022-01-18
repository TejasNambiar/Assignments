package com.cg.student.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.student.entity.StudentDetails;
import com.cg.student.entity.StudentExamResults;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentServiceInf.
 */
public interface StudentServiceInf {

	/**
	 * Gets the student by roll number.
	 *
	 * @param rollNumber the roll number
	 * @return the student by roll number
	 */
	ResponseEntity<StudentExamResults> getStudentByRollNumber(String rollNumber);

	/**
	 * Gets the student results.
	 *
	 * @return the student results
	 */
	List<StudentExamResults> getStudentResults();

	/**
	 * Adds the student detail.
	 *
	 * @param student the student
	 * @return the response entity
	 */
	ResponseEntity<StudentExamResults> addStudentDetail(StudentExamResults student);


	/**
	 * Gets the student details.
	 *
	 * @return the student details
	 */
	List<StudentDetails> getStudentDetails();

	List<StudentDetails> updateStudentDetails();
}

// TODO: custom Exceptions