package com.cg.student.exception;

public class DataExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataExistException(String message) {
		super(message);
	}
}
