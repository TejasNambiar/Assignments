package com.cg.student.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// TODO: Auto-generated Java_doc
/**
 * The Class StudentException.
 * 
 * GLOBAL CONTROLLER EXCEEPTION HANDLER
 */
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Instantiates a new student exception.
	 */
	public ControllerExceptionHandler() {}

	/**
	 * Handle data exist exception.
	 *
	 * @param dx the dx
	 * @return the response entity
	 */
	@ExceptionHandler(value = DataExistException.class)
	public ResponseEntity<Object> handleDataExistException(DataExistException dx) {
		return new ResponseEntity<>(dx.getMessage(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle student exceptions.
	 *
	 * @param dx the dx
	 * @return the response entity
	 */
	@ExceptionHandler(value = StudentExceptions.class)
	public ResponseEntity<Object> handleStudentExceptions(StudentExceptions dx) {

		if(dx.getMessage()
				.equalsIgnoreCase("NO resultset returned containing Student Data. Check dataset connection"))

			return new ResponseEntity<>(dx.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(dx.getMessage(), HttpStatus.NOT_FOUND);
	}
}
