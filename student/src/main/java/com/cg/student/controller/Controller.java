package com.cg.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.student.Interface.IController;
import com.cg.student.entity.StudentExamResults;
import com.cg.student.entity.StudentJPA;
import com.cg.student.exception.DataExistException;
import com.cg.student.exception.DataNotFoundException;
import com.cg.student.service.StudentServiceInf;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/students")
public class Controller implements IController {

	@Autowired
	StudentServiceInf service;

	@Override
	@GetMapping("/postgre")
	public ResponseEntity<List<StudentJPA>> dataFromRepo() {
		return new ResponseEntity<List<StudentJPA>>(service.listFromRepository(), HttpStatus.ACCEPTED);
	}

	@Override
	@GetMapping("/getstudentdetails")
	public ResponseEntity<List<StudentExamResults>> getStudentDetails() {
		return new ResponseEntity<List<StudentExamResults>>(service.getStudentDetails(), HttpStatus.ACCEPTED);
	}

	@Override
	@GetMapping("/getstudentbyrollnumber/{rollnumber}")
	public ResponseEntity<StudentExamResults> getStudentByRollNumber(@PathVariable String rollnumber)
			throws DataNotFoundException {

		ResponseEntity<StudentExamResults> res;

		res = service.getStudentByRollNumber(rollnumber);
		if (res == null)
			throw new DataNotFoundException("Student Not Found");

		return res;

	}

	@Override
	@PostMapping("/addstudentresult")
	public ResponseEntity<StudentExamResults> addStudentDetails(@RequestBody StudentExamResults student) {
		ResponseEntity<StudentExamResults> res = service.addStudentDetail(student);
		if (res == null)
			throw new DataExistException("Data aleady Exist");
		return res;
	}
}
