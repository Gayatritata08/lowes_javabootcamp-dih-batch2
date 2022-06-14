package com.assignments.empapp.springrest.dao;

import java.util.List;

import com.assignments.empapp.springrest.exception.EmployeeException;
import com.assignments.empapp.springrest.model.Employee;

public interface EmployeeDao {

	public Employee create(Employee emp) throws EmployeeException;

	public Employee update(int empId ,Employee emp) throws EmployeeException;

	public boolean delete(int empId);

	public Employee get(int empId) throws EmployeeException;

	public List<Employee> getAll();

}
