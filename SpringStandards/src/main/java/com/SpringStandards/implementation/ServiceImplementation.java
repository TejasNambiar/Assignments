package com.SpringStandards.implementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.SpringStandards.model.Student;
import com.SpringStandards.model.StudentJPA;
import com.SpringStandards.repository.StudentRepository;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ServiceImplementation implements Business_Methods {

	@Autowired
	StudentRepository repository;

	@Override
	public List<Student> getDetails()
			throws FileNotFoundException, IOException, StreamReadException, DatabindException {

		float total = 0;
		Logger logger = Logger.getLogger(ServiceImplementation.class.getName());

		try (InputStream stream = new FileInputStream(
				new File("D:\\GE_Project\\Assignments\\Assignment 1\\Spring\\src\\main\\resources\\student.json"))) {

			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Student>> typeReference = new TypeReference<List<Student>>() {
			};
			List<Student> students = mapper.readValue(stream, typeReference);

			for (Student s : students) {
				logger.info("RollNumber:: " + s.getRollNumber() + "\nName:: " + s.getName() + "\nMark1:: "
						+ s.getMark1() + "\nMark2:: " + s.getMark2() + "\nMark3:: " + s.getMark3() + "\nTotal:: "
						+ s.getTotal() + "\nGrade:: " + s.getGrade());
				total = s.getMark1() + s.getMark2() + s.getMark3();
				s.setTotal((int) total);
				if (total / 3 >= 90)
					s.setGrade("10");
				else if (total / 3 >= 80)
					s.setGrade("9");
				else if (total / 3 > 70)
					s.setGrade("8");
				else if (total / 3 > 60)
					s.setGrade("7");
				else if (total / 3 > 50)
					s.setGrade("6");
				else
					s.setGrade("Fail");
			}

			return students;

		}
	}

	@Override
	public List<StudentJPA> listFromRepository() {
		return repository.findAll();
	}

	@Override
	public List<StudentJPA> findByName(String name) {

		// calling query method from repository class
		return repository.findByNameIgnoreCase(name);
	}

	@Override
	public Streamable<StudentJPA> findNameSequence(String sequence) {
		return repository.findByNameContaining(sequence);
	}

}
