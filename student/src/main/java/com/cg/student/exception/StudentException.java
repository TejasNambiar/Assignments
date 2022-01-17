package com.cg.student.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
 * GLOBAL CONTROLLER EXCEEPTION HANDLER
 */
@ControllerAdvice
public class StudentException extends ResponseEntityExceptionHandler {

	public StudentException() {
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<String, String>();

		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}

		return new ResponseEntity<Object>(errors, status);
	}

	@ExceptionHandler(value = DataNotFoundException.class)
	public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException dx) {
		return new ResponseEntity<>(dx.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = DataExistException.class)
	public ResponseEntity<Object> handleDataExistException(DataExistException dx) {
		return new ResponseEntity<>(dx.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
