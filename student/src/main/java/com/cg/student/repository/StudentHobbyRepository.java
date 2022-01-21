package com.cg.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.student.entity.Hobbies;

public interface StudentHobbyRepository extends JpaRepository<Hobbies, String> {

}
