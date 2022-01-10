package com.Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Assignment.model.Student;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Implementation {

	public List<Student> getAll() {

		float total = 0;

		try {

			ObjectMapper mapper = new ObjectMapper();
			InputStream inputStream = new FileInputStream(
					new File("D:\\eclipse-workspace\\Assignment1\\src\\main\\resources\\student.json"));

			TypeReference<List<Student>> typeReference = new TypeReference<List<Student>>() {
			};
			List<Student> students = mapper.readValue(inputStream, typeReference);

			for (Student s : students) {
				System.out.println("RollNumber:: " + s.getRollNumber() + "\nName:: " + s.getName() + "\nMark1:: "
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

			inputStream.close();
			return students;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ArrayList<Student>();
	}
}
