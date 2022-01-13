package com.SpringStandards.implementation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.data.util.Streamable;

import com.SpringStandards.model.Student;
import com.SpringStandards.model.StudentJPA;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

public interface Business_Methods {
	List<Student> getDetails() throws FileNotFoundException, IOException, StreamReadException, DatabindException;

	// method to get all data
	List<StudentJPA> listFromRepository();

	// method to get by name
	List<StudentJPA> findByName(String name);

	Streamable<StudentJPA> findNameSequence(String sequence);
}
