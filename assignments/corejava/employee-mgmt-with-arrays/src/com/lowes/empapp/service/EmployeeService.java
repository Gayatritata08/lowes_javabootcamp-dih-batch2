package com.lowes.empapp.service;

import java.util.InputMismatchException;

import com.lowes.empapp.exception.EmployeeException;

public interface EmployeeService {

	public abstract void insertEmpData() throws InputMismatchException, EmployeeException;

	public void updateEmpData() throws InputMismatchException, EmployeeException;;

	public void deleteEmpData() throws InputMismatchException, EmployeeException;

	public void viewAllEmpData() throws InputMismatchException, EmployeeException;

	public void viewEmployeData() throws InputMismatchException, EmployeeException;

}
