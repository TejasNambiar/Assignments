package com.cg.student.Interface;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.student.entity.StudentExamResults;
import com.cg.student.entity.StudentJPA;
import com.cg.student.exception.DataNotFoundException;

public interface IController {

	@GetMapping("/postgre")
	public ResponseEntity<List<StudentJPA>> dataFromRepo();

	@GetMapping("/getstudentdetails")
	public ResponseEntity<List<StudentExamResults>> getStudentDetails();

	@GetMapping("/getstudentbyrollnumber/{rollnumber}")
	public ResponseEntity<StudentExamResults> getStudentByRollNumber(@PathVariable String rollnumber)
			throws DataNotFoundException;

	@PostMapping("/addstudentresult")
	public ResponseEntity<StudentExamResults> addStudentDetails(@Valid @RequestBody StudentExamResults student);
}
