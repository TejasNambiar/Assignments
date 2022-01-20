package com.cg.student.Interface;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.student.entity.StudentDetails;
import com.cg.student.entity.StudentExamResults;
import com.cg.student.exception.StudentExceptions;



// TODO: Auto-generated Java_doc
/**
 * The Interface IController.
 */
public interface IController {

	/**
	 * Gets the student results.
	 *
	 * @return the student results
	 * @throws StudentExceptions the student exceptions
	 */
	@GetMapping("/getstudentresults")
	public ResponseEntity<List<StudentExamResults>> getStudentResults() 
			throws StudentExceptions;

	/**
	 * Gets the student details.
	 *
	 * @return the student details
	 * @throws StudentExceptions the student exceptions
	 */
	@GetMapping("/getstudentdetails")
	public ResponseEntity<List<StudentDetails>> getStudentDetails() 
			throws StudentExceptions;

	/**
	 * Gets the student by roll number.
	 *
	 * @param rollnumber the roll number
	 * @return the student by roll number
	 * @throws StudentExceptions the student exceptions
	 */
	@GetMapping("/getstudentbyrollnumber/{rollnumber}")
	public ResponseEntity<StudentExamResults> getStudentByRollNumber(@PathVariable String rollnumber)
			throws StudentExceptions;

	ResponseEntity<List<StudentDetails>> updateStudentDetails() throws StudentExceptions;
}
