package com.cg.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.student.Interface.IController;
import com.cg.student.entity.StudentDetails;
import com.cg.student.entity.StudentExamResults;
import com.cg.student.exception.StudentExceptions;
import com.cg.student.service.StudentServiceInf;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/students")
public class Controller implements IController {

	/** The service. */
	@Autowired
	StudentServiceInf service;

	/**
	 * Gets the student results.
	 *
	 * @return the student results
	 * @throws StudentExceptions the student exceptions
	 */
	@Override
	@GetMapping("/getstudentresults")
	public ResponseEntity<List<StudentExamResults>> getStudentResults() throws StudentExceptions {
		
		List<StudentExamResults> results = service.getStudentResults();
		
		if(!results.isEmpty())
			return new ResponseEntity<List<StudentExamResults>>(results, HttpStatus.ACCEPTED);
		
		throw new StudentExceptions("NO resultset returned containing Student Data. Check dataset connection");
	}

	/**
	 * Gets the student details.
	 *
	 * @return the student details
	 * @throws StudentExceptions the student exceptions
	 */
	@Override
	@GetMapping("/getstudentdetails")
	public ResponseEntity<List<StudentDetails>> getStudentDetails() throws StudentExceptions {
		
		List<StudentDetails> details = service.getStudentDetails();
		
		if(!details.isEmpty())
			return new ResponseEntity<List<StudentDetails>>(details, HttpStatus.ACCEPTED);
		
		throw new StudentExceptions("NO resultset returned containing Student Data. Check dataset connection");
	}

	/**
	 * Gets the student by roll number.
	 *
	 * @param rollnumber the roll number
	 * @return the student by roll number
	 * @throws StudentExceptions the student exceptions
	 */
	@Override
	@GetMapping("/getstudentbyrollnumber/{rollnumber}")
	public ResponseEntity<StudentExamResults> getStudentByRollNumber(@PathVariable String rollnumber) throws StudentExceptions{

		ResponseEntity<StudentExamResults> res = service.getStudentByRollNumber(rollnumber);
		
		/**
		 * performing null check on retrieved data
		 */
		if (res != null)
			return res;
		
		throw new StudentExceptions("Found no Student with rollnumber:: "+ rollnumber);
		

	}
	
	@Override
	@PutMapping("/updatestudentdetails")
	public ResponseEntity<List<StudentDetails>> updateStudentDetails() throws StudentExceptions, NullPointerException {
		
		List<StudentDetails> details = service.getStudentDetails();
		
		if(!details.isEmpty())
			return new ResponseEntity<List<StudentDetails>>(details, HttpStatus.ACCEPTED);
		
		throw new StudentExceptions("NO resultset returned containing Student Data. Check dataset connection");
	}

}
