package com.cg.student.controller;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.student.entity.StudentExamResults;
import com.cg.student.exception.StudentExceptions;
import com.cg.student.service.StudentServiceImpl;
import com.cg.student.service.StudentServiceInf;

@SpringBootTest
public class ControllerTest {
	
	@Mock
	StudentServiceInf serviceInf;
	
	@InjectMocks
	Controller controller;
	
	@Test
	@DisplayName("Testing getStudentResults")
	void testGetStudentDetails_toReturn_List() throws StudentExceptions {
		
		List<StudentExamResults> list = new ArrayList<StudentExamResults>();
	
		list.add(new StudentExamResults("17241a05m0", 12, 80, 90, 0, ""));
		list.add(new StudentExamResults("17241a05m1", 91, 40, 70, 0, ""));
		list.add(new StudentExamResults("17241a05m2", 90, 80, 70, 0, ""));
		
		when(serviceInf.getStudentResults()).thenReturn(list);
		
		ResponseEntity<List<StudentExamResults>> results = controller.getStudentResults();
		
		assertAll(
					() -> assertEquals(list, results.getBody()),
					() -> assertEquals(202, results.getStatusCodeValue()),
					() -> assertEquals(3, results.getBody().size())
				);
	}
	@Nested
	class Testing_RollNumber{
		
		@Test
		@DisplayName("Testing getStudent:: RollNumber")
		void testGetStudentByRollNumber_toReturn_ResultObject() throws StudentExceptions {
			
			String rollnumber = "17241a05m0";
			StudentExamResults results = new StudentExamResults();
			
			results.setRollNumber(rollnumber)
			   .setMark1(12)
			   .setMark2(80)
			   .setMark3(90)
			   .setGrade("")
			   .setTotal(0);
			
			ResponseEntity<StudentExamResults> response = new ResponseEntity<StudentExamResults>(results, HttpStatus.FOUND);
					
			when(serviceInf.getStudentByRollNumber(rollnumber)).thenReturn(response);
			
			ResponseEntity<StudentExamResults> controllerResponse = controller.getStudentByRollNumber(rollnumber);
			
			assertAll(
						() -> assertEquals(results, controllerResponse.getBody()),
						() -> assertEquals(302, controllerResponse.getStatusCodeValue()),
						() -> assertNotNull(controllerResponse)
					);
		}
		
		@Test
		@DisplayName("Testing getStudent:: RollNumber:: StudentException Thrown")
		void testGetStudentByRollNumber_toThrow_StudentException_onNull(){
			
			String rollnumber = "17241a05m10";
					
			when(serviceInf.getStudentByRollNumber(rollnumber)).thenReturn(null);
			
			assertThrowsExactly(StudentExceptions.class, () -> controller.getStudentByRollNumber(rollnumber));
		}

	}	

}
