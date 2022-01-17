package com.cg.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.student.entity.StudentExamResults;

@Repository
public interface StudentExamRepository extends JpaRepository<StudentExamResults, String> {

	StudentExamResults findByRollNumber(String rollNumber);

}
