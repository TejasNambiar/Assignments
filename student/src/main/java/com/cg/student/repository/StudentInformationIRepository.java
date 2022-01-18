package com.cg.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.student.entity.StudentJPA;

public interface StudentInformationIRepository extends JpaRepository<StudentJPA, String> {

}
