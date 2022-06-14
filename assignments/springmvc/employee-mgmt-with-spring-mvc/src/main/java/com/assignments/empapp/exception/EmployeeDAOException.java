package com.assignments.empapp.exception;


public class EmployeeDAOException extends Exception{

	public EmployeeDAOException() {
		System.out.println("Employee Database exception occurred");
	}
	
	public EmployeeDAOException(String string) {
		// TODO Auto-generated constructor stub
		System.out.println(string);
	}
}