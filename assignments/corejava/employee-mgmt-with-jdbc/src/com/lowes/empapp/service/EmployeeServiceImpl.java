package com.lowes.empapp.service;

import java.util.HashMap;
import java.util.List;

import com.lowes.empapp.dao.EmployeeServiceDao;
import com.lowes.empapp.exception.EmployeeException;
import com.lowes.empapp.model.Employee;

public class EmployeeServiceImpl {

	HashMap<Integer, Employee> employee = new HashMap<Integer, Employee>();

	Employee empObj;
	EmployeeServiceDao empDao = new EmployeeServiceDao();

	public boolean create(Employee emp) throws EmployeeException {
		empDao.create(emp);
		return true;
	}

	public boolean update(Employee emp) throws EmployeeException {
		empDao.update(emp);
		return true;
	}

	public boolean delete(int empId) {
		empDao.delete(empId);
		return false;
	}

	public Employee get(int empId) throws EmployeeException {
		empDao.get(empId);
		return empObj;
	}

	public List<Employee> getAll() {
		empDao.getAll();
		return (List<Employee>) employee;
	}

	public void bulkImport() {
		empDao.bulkImport();

	}

	public void bulkExport() {
		empDao.bulkExport();

	}

	public void viewData(int empId) {
		
		empDao.viewData(empId);
	}

	public void viewAll() {
	
		empDao.viewAll();
	}
}
