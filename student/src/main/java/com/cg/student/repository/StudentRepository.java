package com.cg.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import com.cg.student.entity.StudentJPA;

public interface StudentRepository extends JpaRepository<StudentJPA, String> {

	// Query Method to find student by Name
	List<StudentJPA> findByNameIgnoreCase(String name);

	// implementing streams to find by sequence
	Streamable<StudentJPA> findByNameContaining(String sequence);

}
