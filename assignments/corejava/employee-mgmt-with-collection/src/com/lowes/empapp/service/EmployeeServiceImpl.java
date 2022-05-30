package com.lowes.empapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.lowes.empapp.exception.EmployeeException;
import com.lowes.empapp.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	Scanner in = new Scanner(System.in);
	HashMap<Integer, Employee> employee = new HashMap<Integer, Employee>();
	Employee empObj;

	@Override
	public boolean create(Employee emp) {
		try {
			empObj = readEmployeeData(emp);
			empObj.setEmpId(employee.size() + 1);
			employee.put(empObj.getEmpId(), empObj);			
		} catch (Exception e) {
			e.getMessage();
		}
		return employee.isEmpty() ? false : true;
	}

	@Override
	public boolean update(Employee emp) {
		boolean status = false;
		try {
			if (employee.isEmpty()) {
				System.out.println("No records to update.");
			}
			System.out.println("Please enter the emplyee id to modify");
			int empId = Integer.parseInt(in.next());
			if (employee != null && employee.containsKey(empId)) {
				empObj = readEmployeeData(emp);
				empObj.setEmpId(empId);
				employee.put(empId, empObj);
				status = true;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean delete(int empId) {
		boolean status = false;
		if (employee.isEmpty()) {
			System.out.println("No records to delete.");

		}
		System.out.println("Please enter the emplyee id to delete");
		empId = Integer.parseInt(in.next());
		if(employee !=null && employee.containsKey(empId)) {
		employee.remove(empId);
		System.out.println("Success");
		status =true;
	}

		return status;
	}
	
	
	public void viewAll(){

		try {
			List<Employee> empList = getAll();
			if (!empList.isEmpty() && empList.size() > 0) {
				printHeader();
				for (Employee empListObj : empList) {
					System.out.println("\t" + empListObj.getEmpId() +
							"\t	" + empListObj.getName() + 
							"\t	" + empListObj.getAge() + 
							"\t	" + empListObj.getDepartment() + 
							"\t	" + empListObj.getDesignation()+
							"\t		" + empListObj.getCountry());
				}
			}
		} catch (Exception e) {
			new EmployeeException("Exception in view All Employee Data");
			e.printStackTrace();
		}

	}
    
	public void viewData(int empId) {
		System.out.println("Please enter the employee id to display");
		empId = in.nextInt();
		try {
			Employee empViewObj = get(empId);
			printHeader();
			System.out.println("\t" + empViewObj.getEmpId() +
					"\t	" +empViewObj.getName() +
					"\t	" +empViewObj.getAge() +
					"\t	" +empViewObj.getDepartment() +
					"\t	" +empViewObj.getDesignation() +
					"\t		" +empViewObj.getCountry());
		} catch (EmployeeException e) {
			new EmployeeException("Exception in view Employee data");
			e.printStackTrace();
		}
	}

	@Override
	public Employee get(int empId) throws EmployeeException {
	if(employee.size() ==0 || employee.isEmpty() ) {
		System.out.println("No records to display");
	}else {
		empObj = employee.get(empId);
	}
	return empObj;
	}
		

	@Override
	public List<Employee> getAll() {
		ArrayList<Employee> empList = new ArrayList<Employee>(employee.values());
		return (List<Employee>) empList;
	}

	private Employee readEmployeeData(Employee emp) {

		try {
			Scanner sc = new Scanner(System.in);
			emp = new Employee();
			System.out.println("Please enter the employee Name");
			String name = sc.next();
			emp.setName(name);

			System.out.println("Please enter the Age");
			int age = sc.nextInt();
			emp.setAge(age);

			System.out.println("Please enter the department");
			String department = sc.next();
			emp.setDepartment(department);

			System.out.println("Please enter the designation");
			String designation = sc.next();
			emp.setDesignation(designation);

			System.out.println("Please enter the employee Country");
			String country = sc.next();
			emp.setCountry(country);
			
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	private void printHeader() {
		System.out.println("\t" + "Emp Id" +
				"\t" + "Employee Name" +
				"\t" + "Employee Age" +
				"\t" + "Employee Department"+
				"\t" + "Employee Designation" +
				"\t" + "Country");
	}

}
