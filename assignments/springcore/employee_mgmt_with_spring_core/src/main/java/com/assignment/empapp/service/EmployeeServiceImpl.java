package com.assignment.empapp.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.empapp.dao.EmployeeDao;
import com.assignment.empapp.exception.EmployeeException;
import com.assignment.empapp.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	Scanner in = new Scanner(System.in);
	HashMap<Integer, Employee> employee = new HashMap<Integer, Employee>();
	List<Employee> empList;

	Employee empObj;

	@Autowired
	private EmployeeDao empDao;
	boolean status;

	public boolean create(Employee emp) {
		try {
			empObj = readEmployeeData(emp);
			status = empDao.create(empObj);

		} catch (Exception e) {
			e.getMessage();
		}
		return status;
	}

	private Employee readEmployeeData(Employee emp) throws EmployeeException {

		try {
			System.out.println("Please enter the employee name");
			String name = in.next();
			emp.setName(name);

			boolean valStatus = true;
			do {
				System.out.println("Please enter the Age");
				int age = in.nextInt();
				emp.setAge(age);
				valStatus = validate(emp, employee -> employee.getAge() >= 20 && employee.getAge() <= 60);
				if (valStatus) {
					System.out.println("employee age with in the range");
				} else {
					System.out.println("Validation Error:Please enter the employee age between 20 to 60");
				}
			} while (!valStatus);

			System.out.println("Please enter the employee designation");
			String designation = in.next();
			emp.setDesignation(designation);

			System.out.println("Please enter the employee department");
			String department = in.next();
			emp.setDepartment(department);

			System.out.println("Please enter the employee Country");
			String country = in.next();
			emp.setCountry(country);

			System.out.println("Please enter the date of joing in dd/MM/yyy format");
			String doj = in.next();
			setDoj(emp, doj);

			return emp;

		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		return emp;
	}

	private void setDoj(Employee emp, String doj) throws EmployeeException {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
			formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate date = LocalDate.parse(doj, formatter);
			System.out.println(date);
			emp.setDoj(date);
		} catch (Exception e) {
			throw new EmployeeException("Please enter the doj in correct format");

		}
	}

	public boolean update(Employee emp) {
		try {			
			System.out.println("Please enter the employee id to update ? ");
			int id = in.nextInt();
			empObj = readEmployeeData(emp);
			empObj.setEmpId(id);
			status = empDao.update(empObj);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean delete(int empId) {
		System.out.println("Please enter the employee id to delete the employee record");
		empId = in.nextInt();
		status = empDao.delete(empId);
		return status;
	}

	public void viewData(int empId) throws EmployeeException {
		System.out.println("Please enter the employee id to view data");
		empId = in.nextInt();
		try {
			Employee empObj = empDao.get(empId);
			if (empObj != null) {
				printHeader();
				System.out.println("\t" + empObj.getEmpId() + "\t" + empObj.getName() + "\t" + empObj.getAge()
						+ "\t	" + empObj.getDepartment() + "\t" + empObj.getDesignation() + "\t" + empObj.getCountry()
						+ empObj.getDoj() + "\t" + empObj.getCreatedTime() + "\t" + empObj.getModifiedTime());
			} else {
				System.out.println("There are no records to dispaly with the given employee id");
			}

		} catch (EmployeeException e) {
			e.printStackTrace();
		}

	}

	public void viewAll() {

		try {
			List<Employee> empList = empDao.getAll();
			if (!empList.isEmpty() && empList.size() > 0) {
				printHeader();
				for (Employee empListObj : empList) {
					System.out.println("\t" + empListObj.getEmpId() + "\t" + empListObj.getName() + "\t"
							+ empListObj.getAge() + "\t	" + empListObj.getDepartment() + "\t"
							+ empListObj.getDesignation() + "\t" + empListObj.getCountry() + empListObj.getDoj() + "\t"
							+ empListObj.getCreatedTime() + "\t" + empListObj.getModifiedTime());

				}
			} else {
				System.out.println("No records to display !!!");
			}
		} catch (Exception e) {
			new EmployeeException("Exception in view All Employee Data");
			e.printStackTrace();
		}

	}

	private void printHeader() {
		System.out.println("\t" + "Id" + "\t" + "Name" + "\t" + "Age" + "\t" + "Department" + "\t" + "Designation"
				+ "\t" + "Country" + "\t" + "Doj" + "\t" + "CreatedTime" + "\t" + "ModifiedTime");
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

	@Override
	public void bulkImport() throws EmployeeException {
		System.out.println("Thread Name:" + Thread.currentThread().getName());
		String filePath = "input.txt";

		String line;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length >= 0) {
					empObj = new Employee();
					empObj.setName(parts[0]);
					empObj.setAge(Integer.parseInt(parts[1]));
					empObj.setDepartment(parts[2]);
					empObj.setDesignation(parts[3]);
					empObj.setCountry(parts[4]);
					empObj.setDoj(LocalDate.parse(parts[5], DateTimeFormatter.ofPattern("dd/MM/yyy")));
					empObj.setCreatedTime(LocalDateTime.now());
					empDao.create(empObj);
				} else {
					System.out.println("ignoring line: " + line);
				}
				System.out.println("import is success");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void bulkExport() {
		System.out.println("Thread Name:" + Thread.currentThread().getName());
		FileWriter writer = null;
		try {
			try {
				writer = new FileWriter("output.txt");
				empList = getAll();
				for (Employee empListObj : empList) {
					writer.write(empListObj.getEmpId() + ",");
					writer.write(empListObj.getName() + ",");
					writer.write(empListObj.getAge() + ",");
					writer.write(empListObj.getDepartment() + ",");
					writer.write(empListObj.getDesignation() + ",");
					writer.write(empListObj.getDoj() + ",");
					writer.write(empListObj.getCreatedTime() + ",");
					writer.write(empListObj.getModifiedTime() + "");

					writer.write("\n");
				}
				System.out.println("Bulk export is success with the records size " + empList.size() + "!!!");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean validate(Employee emp, Predicate<Employee> validator) {
		return validator.test(emp);
	}

	@SuppressWarnings("rawtypes")
	Comparator EMPLOYEE_SORT_BY_NAME = new Comparator<Employee>() {
		@Override
		public int compare(Employee o1, Employee o2) {
			if (o1 instanceof Employee && o2 instanceof Employee) {
				return ((Employee) o1).getName().compareTo(((Employee) o2).getName());
			}
			return 0;
		}
	};

	public void printStatistics() {
		List<Employee> empList = getAll();

		long n = getEmployeeCountAgeGreaterThan(empObj -> empObj.getAge() > 10);
		System.out.println("Employees Age greater than 50 count " + n);

		List<Integer> ageGrtThanX = getEmployeesIdsAgeGreaterThan(10);
		System.out.println("getEmployeesIdsAgeGreaterThan () :: " + ageGrtThanX);

		Map<String, Long> empCountMap = getEmployeeCountByBeparment();
		System.out.println("getEmployeeCountByBeparment" + empCountMap);

		List<String> deptList = getDepartmentsHaveEmployeeMorethan(3);
		System.out.println("getDepartmentsHaveEmployeeMorethan :: \n" + deptList);

		List<String> namesList = getEmployeeNameStartsWith("M");
		System.out.println("getEmployeeNameStartsWith" + namesList);
	}

	public long getEmployeeCountAgeGreaterThan(Predicate<Employee> condition) {

		return empList.stream().filter(condition).count();

	}

	public List<Integer> getEmployeesIdsAgeGreaterThan(int age) {

		return empList.stream().filter(empObj -> empObj.getAge() > age).map(empObj -> empObj.getEmpId())
				.collect(Collectors.toList());
	}

	public Map<String, Long> getEmployeeCountByBeparment() {

		return empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
	}

	public Map<String, Long> getEmployeeCountByDepartmentOrder() {

		return empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));
	}

	public List<String> getDepartmentsHaveEmployeeMorethan(int criteria) {

		return empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > criteria).map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}

	public List<String> getEmployeeNameStartsWith(String s) {
		return empList.stream().map(Employee::getName).filter(name -> name.startsWith(s))
				.collect(Collectors.toList());
	}	

}
