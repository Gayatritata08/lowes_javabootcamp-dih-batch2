package com.labs.spring.boot.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.spring.boot.Entity.Employee;
import com.labs.spring.boot.exception.EmployeeException;
import com.labs.spring.boot.repositry.EmployeeRepositry;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepositry repo;

	public Employee create(Employee employee) throws EmployeeException {

		return repo.save(employee);
	}

	public List<Employee> list() throws EmployeeException {
		System.out.println("I am also in list method");
		return repo.findAll();
	}

	public Employee get(int id) {

		return repo.findById(id).get();
	}

	public Employee update(int id, Employee employee) {

		return repo.save(employee);
	}

	public void delete(int id) {

		repo.deleteById(id);
	}

}
