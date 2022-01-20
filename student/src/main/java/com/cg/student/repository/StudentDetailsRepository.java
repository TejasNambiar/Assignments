package com.cg.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.student.entity.StudentDetails;

/**
 * The Interface StudentDetailsRepository.
 */
@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetails, String> {

	StudentDetails findByRollNumber(String rollNumber);

}
