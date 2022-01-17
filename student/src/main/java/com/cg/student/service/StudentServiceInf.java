package com.cg.student.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.student.entity.StudentExamResults;
import com.cg.student.entity.StudentJPA;

public interface StudentServiceInf {

	ResponseEntity<StudentExamResults> getStudentByRollNumber(String rollNumber);

	List<StudentExamResults> getStudentDetails();

	ResponseEntity<StudentExamResults> addStudentDetail(StudentExamResults student);

	List<StudentJPA> listFromRepository();
}
