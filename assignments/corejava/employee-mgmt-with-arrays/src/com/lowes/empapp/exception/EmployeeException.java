package com.lowes.empapp.exception;

public class EmployeeException extends Exception {
	
	public EmployeeException(String message) {
		super();
		System.out.println(message);
	}
	
	public EmployeeException() {
		super();
	}
	
	public EmployeeException(String message,Throwable cause) {
		super();
	}
}
