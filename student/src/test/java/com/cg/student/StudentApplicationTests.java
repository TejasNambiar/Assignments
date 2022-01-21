package com.cg.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.cg.student.entity.StudentDetails;
import com.cg.student.entity.StudentExamResults;
import com.cg.student.repository.StudentDetailsRepository;
import com.cg.student.repository.StudentExamRepository;
import com.cg.student.service.StudentServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentApplicationTests.
 */
@SpringBootTest
class StudentApplicationTests {


	/**
	 * Mocking StudentExamRepository for JUnit Testing.
	 *
	 * @Mock - Mocks the repository
	 */
	@Mock
	private StudentExamRepository mockResultRepo;

	/**
	 * Mocking StudentDetailsRepository for JUnit Testing.
	 *
	 * @Mock - Mocks the repository
	 */
	@Mock
	private StudentDetailsRepository mockDetailsRepo;

	/**
	 * Testing the ServiceImpl Class using Mockito.
	 *
	 * @InjectMocks - Injects mocks into class being tested
	 */
	@InjectMocks
	StudentServiceImpl serviceImpl;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * The Class MockingRollNumber.
	 */
	@Nested
	class MockingRollNumber{

		/**
		 * Test get roll number to return null on random string.
		 */
		@Test
		@DisplayName("Return Null:: wrong rollNumber")
		final void testGetRollNumber_toReturnNull_onRandomString() {

			when(mockResultRepo.findByRollNumber(anyString())).thenReturn(null);

			ResponseEntity<StudentExamResults> details = serviceImpl.getStudentByRollNumber("qwqdqwd");

			assertNull(details);
		}

		/**
		 * Test get roll number to return object on proper string.
		 */
		@Test
		@DisplayName("Return Result Object:: Right rollNumber")
		final void testGetRollNumber_toReturnObject_onProperString() {

			String rollNumber = "17241a05m0";

			StudentExamResults results = new StudentExamResults();

			results.setGrade("");
			results.setRollNumber("17241a05m0");
			results.setMark1(12);
			results.setMark2(80);
			results.setMark3(90);
			results.setTotal(0);

			when(mockResultRepo.findByRollNumber(rollNumber)).thenReturn(results);

			ResponseEntity<StudentExamResults> serviceResult = serviceImpl.getStudentByRollNumber(rollNumber);

			assertEquals(90, serviceResult.getBody().getMark3());
		}
	}
	
	/**
	 * The Class MockingListMethods.
	 */
	@Nested
	class MockingListMethods{
		
		/**
		 * Test get student results.
		 */
		@Test
		@DisplayName("Testing GetStudents:: Business Logic ")
		void testGetStudentResults() {
	
			List<StudentExamResults> list = new ArrayList<StudentExamResults>();
//			list.add(new StudentExamResults("17241a05m0", 12, 80, 90, 60, "D"));
//			list.add(new StudentExamResults("17241a05m1", 91, 40, 70, 67, "D"));
//			list.add(new StudentExamResults("17241a05m2", 90, 80, 70, 80, "B"));
//			list.add(new StudentExamResults("17241a05m3", 70, 75, 75, 73, "C"));
//			list.add(new StudentExamResults("17241a05m4", 89, 34, 23, 48, "F"));
//			list.add(new StudentExamResults("17241a05m5", 23, 65, 23, 37, "F"));
			
			list.add(new StudentExamResults("17241a05m0", 12, 80, 90, 0, ""));
			list.add(new StudentExamResults("17241a05m1", 91, 40, 70, 0, ""));
			list.add(new StudentExamResults("17241a05m2", 90, 80, 70, 0, ""));
			list.add(new StudentExamResults("17241a05m3", 70, 75, 75, 0, ""));
			list.add(new StudentExamResults("17241a05m4", 89, 34, 23, 0, ""));
			list.add(new StudentExamResults("17241a05m5", 23, 65, 23, 0, ""));
	
			when(mockResultRepo.findAll()).thenReturn(list);
	
			List<StudentExamResults> serviceList = serviceImpl.getStudentResults(); 
	
			assertAll(
					() -> assertThat(serviceList).isNotEmpty(),
					() -> assertEquals(6, list.size(), "to compare the list size"),
					() -> assertEquals("17241a05m4", list.get(4).getRollNumber(), "Comparing rollnumber at index 4"),
					() -> assertEquals(48, list.get(4).getTotal(), "Comparing Total at index 4"),
					() -> assertEquals(73, list.get(3).getTotal(), "Comparing Total at index 3"),
					() -> assertEquals("D", list.get(0).getGrade(), "Comparing Grade at index 0"),
					() -> assertEquals("F", list.get(5).getGrade(), "Comparing Grade at index 5")
					);
		}
		
		/**
		 * Test get student details.
		 */
		@Test
		@DisplayName("Testing GetStudentDetails ")
		void testGetStudentDetails() {
	
			StudentExamResults result0, result1;
			

			result0 = new StudentExamResults("17241a05m0", 12, 80, 90, 0, "");
			result1 = new StudentExamResults("17241a05m1", 91, 40, 70, 0, "");
			
			List<StudentDetails> list = new ArrayList<>();
			list.add(new StudentDetails("17241a05m0","sample 0","address 0",1285641254,result0));
			list.add(new StudentDetails("17241a05m1","sample 1","address 1",1484589546,result1));
	
			when(mockDetailsRepo.findAll()).thenReturn(list);
	
			List<StudentDetails> serviceList = serviceImpl.getStudentDetails(); 
	
			assertAll(
					() -> assertThat(serviceList).isNotEmpty(),
					() -> assertEquals(2, list.size(), "to compare the list size"),
					() -> assertEquals("17241a05m1", list.get(1).getRollNumber(), "Comparing rollnumber at index 4"),
					() -> assertEquals("17241a05m0", list.get(0).getResults().getRollNumber(), "Comparing rollNumber of inline Object")
					);
		}
		
	}

}
