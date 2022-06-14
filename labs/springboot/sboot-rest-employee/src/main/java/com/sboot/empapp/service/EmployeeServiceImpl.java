package com.sboot.empapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sboot.empapp.Repositry.EmployeeRepositry;
import com.sboot.empapp.exception.EmployeeException;
import com.sboot.empapp.model.Employee;

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
