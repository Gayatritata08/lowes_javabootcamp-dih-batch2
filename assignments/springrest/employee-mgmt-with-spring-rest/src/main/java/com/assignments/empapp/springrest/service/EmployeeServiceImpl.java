package com.assignments.empapp.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignments.empapp.springrest.dao.EmployeeDao;
import com.assignments.empapp.springrest.exception.EmployeeException;
import com.assignments.empapp.springrest.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	List<Employee> empList;

	Employee empObj;
	boolean status;

	@Autowired
	private EmployeeDao empDao;

	public Employee create(Employee emp) {
		try {
		
			empObj = empDao.create(emp);

		} catch (Exception e) {
			e.getMessage();
		}
		return empObj;
	}

	public Employee update(int id, Employee emp) throws EmployeeException {
		try {
			System.out.println("update" + id);
			
			emp.setEmpId(id);
			emp = empDao.update(id, emp);
		} catch (EmployeeException e) {
			throw new EmployeeException("Exception in update() method");
		}
		return emp;
	}

	public boolean delete(int empId) {
		status = empDao.delete(empId);
		return status;
	}

	@Override
	public Employee get(int empId) throws EmployeeException {
		try {
			empObj = empDao.get(empId);
		} catch (EmployeeException e) {
			throw new EmployeeException("Exception in get() method");
		}
		return empObj;
	}

	@Override
	public List<Employee> getAll() {
		empList = empDao.getAll();
		return empList;
	}

}
