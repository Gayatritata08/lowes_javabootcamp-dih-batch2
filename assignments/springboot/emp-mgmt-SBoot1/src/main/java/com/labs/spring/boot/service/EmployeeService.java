package com.labs.spring.boot.service;

import java.util.List;

import com.labs.spring.boot.Entity.Employee;
import com.labs.spring.boot.exception.EmployeeException;

public interface EmployeeService {
	public Employee create(Employee employee) throws EmployeeException;

	public List<Employee> list() throws EmployeeException;

	public Employee get(int id);

	public Employee update(int id, Employee employee);

	public void delete(int id);

}
