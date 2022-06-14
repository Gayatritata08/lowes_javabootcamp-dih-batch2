package com.sboot.empapp.service;

import java.util.List;

import com.sboot.empapp.exception.EmployeeException;
import com.sboot.empapp.model.Employee;

public interface EmployeeService {
	public Employee create(Employee employee) throws EmployeeException;

	public List<Employee> list() throws EmployeeException;

	public Employee get(int id) throws EmployeeException;

	public Employee update(int id, Employee employee) throws EmployeeException;

	public void delete(int id) throws EmployeeException;

}
