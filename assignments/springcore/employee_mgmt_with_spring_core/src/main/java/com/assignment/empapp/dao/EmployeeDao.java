package com.assignment.empapp.dao;

import java.util.List;

import com.assignment.empapp.model.Employee;
import com.assignment.empapp.exception.*;

public interface EmployeeDao {
	
	public boolean create(Employee emp) throws EmployeeException;

	public boolean update(Employee emp) throws EmployeeException;

	public boolean delete(int empId);

	public Employee get(int empId) throws EmployeeException;

	public List<Employee> getAll();

}
