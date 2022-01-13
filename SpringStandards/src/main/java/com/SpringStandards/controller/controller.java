package com.SpringStandards.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringStandards.implementation.Business_Methods;
import com.SpringStandards.model.Student;
import com.SpringStandards.model.StudentJPA;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

/*
 * Defining the controller class for 
 * 
 */
@RestController
@RequestMapping("api/students")
public class controller {

	@Autowired
	Business_Methods service;

	// mapping result and producing as list
	@GetMapping("")
	public List<Student> getStudentsData() {
		try {
			// getting student data from get details
			return service.getDetails();

		}
		// catching errors if any
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<Student>();
	}

	@GetMapping("/postgre")
	public ResponseEntity<List<StudentJPA>> dataFromRepo() {
		return new ResponseEntity<List<StudentJPA>>(service.listFromRepository(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/postgre/{name}")
	public ResponseEntity<List<StudentJPA>> nameFromRepo(@PathVariable String name) {
		return new ResponseEntity<List<StudentJPA>>(service.findByName(name), HttpStatus.ACCEPTED);
	}

	@GetMapping("/postgre/name/{sequence}")
	public ResponseEntity<Streamable<StudentJPA>> findByySequence(@PathVariable String sequence) {
		return new ResponseEntity<Streamable<StudentJPA>>(service.findNameSequence(sequence), HttpStatus.ACCEPTED);
	}
}
