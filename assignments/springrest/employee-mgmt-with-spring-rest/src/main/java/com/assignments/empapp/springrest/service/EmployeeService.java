package com.assignments.empapp.springrest.service;

import java.util.List;

import com.assignments.empapp.springrest.exception.EmployeeException;
import com.assignments.empapp.springrest.model.Employee;

public interface EmployeeService {

	public Employee create(Employee emp);

	public Employee update(int id, Employee emp) throws EmployeeException;

	public boolean delete(int empId);

	public Employee get(int empId) throws EmployeeException;

	public List<Employee> getAll();
}
