package com.cg.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.student.entity.StudentExamResults;
import com.cg.student.entity.StudentJPA;
import com.cg.student.repository.StudentExamRepository;
import com.cg.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServiceInf {

	@Autowired
	StudentExamRepository repository;

	@Autowired
	StudentRepository repository1;

	@Override
	public ResponseEntity<StudentExamResults> getStudentByRollNumber(String rollNumber) {

		StudentExamResults res = repository.findByRollNumber(rollNumber);

		// if roll_number doesn't exist, return null
		if (res == null)
			return null;
		return new ResponseEntity<StudentExamResults>(res, HttpStatus.FOUND);
	}

	@Override
	public List<StudentExamResults> getStudentDetails() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<StudentExamResults> addStudentDetail(StudentExamResults student) {

		// if found return null
		if (getStudentByRollNumber(student.getRollNumber()) != null)
			return null;

		// else proceed
		student.updateTotal();
		student.updateGrade();

		return new ResponseEntity<StudentExamResults>(repository.save(student), HttpStatus.CREATED);
	}

	@Override
	public List<StudentJPA> listFromRepository() {
		return repository1.findAll();
	}
}
