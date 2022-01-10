package com.Assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Assignment.model.Student;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/student")
public class Controller {

	@Autowired
	Implementation service;

	@GetMapping("")
	public List<Student> getData() {
		return service.getAll();
	}
}
