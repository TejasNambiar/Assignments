package com.cg.student.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StudentExceptions extends Exception {
	

	public StudentExceptions() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StudentExceptions(String message, Throwable cause) {
		logger.error(message, cause);
		// TODO Auto-generated constructor stub
	}

	static Logger logger = LoggerFactory.getLogger(StudentExceptions.class);
	
	private static final long serialVersionUID = 1L;

	public StudentExceptions(String msg) {
		super(msg);
	}
	
//	// can use this
//	public StudentExceptions(String msg, Exception e) {
//		logger.error(msg + e.getMessage());;
//	}

}
