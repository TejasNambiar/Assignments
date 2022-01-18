package com.cg.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.student.entity.StudentExamResults;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentExamRepository.
 */
@Repository
public interface StudentExamRepository extends JpaRepository<StudentExamResults, String> {

	/**
	 * Find by roll number.
	 *
	 * @param rollNumber the roll number
	 * @return the student exam results
	 */
	StudentExamResults findByRollNumber(String rollNumber);

}
