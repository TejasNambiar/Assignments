package com.cg.student.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.student.entity.StudentDetails;
import com.cg.student.entity.StudentExamResults;
import com.cg.student.repository.StudentDetailsRepository;
import com.cg.student.repository.StudentExamRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentServiceImpl.
 */
@Service
public class StudentServiceImpl implements StudentServiceInf {

	/** The repository. */
	@Autowired
	StudentExamRepository repository;

	/** The repository 3. */
	@Autowired
	StudentDetailsRepository repository3;

	/** The logger. */
	Logger logger;

	/**
	 * Gets the student by roll number.
	 *
	 * @param rollNumber the roll number
	 * @return the student by roll number
	 */
	@Override
	public ResponseEntity<StudentExamResults> getStudentByRollNumber(String rollNumber) {

		// TODO: null_check for roll_number

		StudentExamResults res = repository.findByRollNumber(rollNumber);

		// checks if roll_number exists, else return null
		if (res != null)
			return new ResponseEntity<StudentExamResults>(res, HttpStatus.FOUND);
		
		return null;
	}

	/**
	 * Gets the student results.
	 *
	 * @return the student results
	 */
	@Override
	public List<StudentExamResults> getStudentResults() {
		List<StudentExamResults> list = repository.findAll();

		list.forEach(result -> {

			int total = (result.getMark1() + result.getMark2() + result.getMark3()) / 3;
			String grade;

			if (total >= 90)
				grade = "A";
			else if (total >= 80)
				grade = "B";
			else if (total >= 70)
				grade = "C";
			else if (total >= 60)
				grade = "D";
			else
				grade = "F";

			result.setGrade(grade);
			result.setTotal(total);
		});
		return list;
	}

	/**
	 * Gets the student details.
	 *
	 * @return the student details
	 */
	@Override
	public List<StudentDetails> getStudentDetails() {
		return repository3.findAll();
	}

	/**
	 * Adds the student detail.
	 *
	 * @param student the student
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<StudentExamResults> addStudentDetail(StudentExamResults student) {

		// if found return null
		if (getStudentByRollNumber(student.getRollNumber()) != null)
			return null;

//		// else proceed
//		student.updateTotal();
//		student.updateGrade();

		return new ResponseEntity<StudentExamResults>(repository.save(student), HttpStatus.CREATED);
	}
}
