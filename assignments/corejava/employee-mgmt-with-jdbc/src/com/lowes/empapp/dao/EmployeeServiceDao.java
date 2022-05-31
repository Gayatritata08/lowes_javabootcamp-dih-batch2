package com.lowes.empapp.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lowes.empapp.exception.EmployeeException;
import com.lowes.empapp.model.Employee;
import com.lowes.empapp.service.EmployeeService;

public class EmployeeServiceDao implements EmployeeService {

	Scanner in = new Scanner(System.in);
	Connection jdbcCon = new JdbcConnection().getConnection();

	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Employee emp;
	List<Employee> empList = null;

	@Override
	public boolean create(Employee emp) {
		Employee empObj = readEmployeeData(emp);
		insertEmployeeData(empObj);
		return true;
	}

	private void insertEmployeeData(Employee empObj) {
		try {
			Statement stmt = jdbcCon.createStatement();
			String insertQueryForPrepareStmt = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
			pstmt = jdbcCon.prepareStatement(insertQueryForPrepareStmt);
			pstmt.setString(1, empObj.getName());
			pstmt.setInt(2, empObj.getAge());
			pstmt.setString(3, empObj.getDesignation());
			pstmt.setString(4, empObj.getDepartment());
			pstmt.setString(5, empObj.getCountry());
		
			
			
			int insertCount = pstmt.executeUpdate();
			pstmt.close();
			jdbcCon.commit();
			System.out.println(insertCount + " Employee(s) inserted");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private Employee readEmployeeData(Employee emp) {
		emp = new Employee();

		System.out.println("Please enter the employee name");
		String name = in.next();
		emp.setName(name);

		System.out.println("Please enter the employee age");
		int age = in.nextInt();
		emp.setAge(age);

		System.out.println("Please enter the employee designation");
		String designation = in.next();
		emp.setDesignation(designation);

		System.out.println("Please enter the employee department");
		String department = in.next();
		emp.setDepartment(department);

		System.out.println("Please enter the employee Country");
		String country = in.next();
		emp.setCountry(country);
		
	

		return emp;
	}

	@Override
	public boolean update(Employee emp) {
		try {
			System.out.println("Please enter the employee id to update ? ");
			int id = in.nextInt();

			String updateQuery = "UPDATE employee SET name=?,age=?,designation=?,department=?,country=? WHERE id=?";

			pstmt = jdbcCon.prepareStatement(updateQuery);
			Employee empObj = readEmployeeData(emp);
			pstmt.setString(1, empObj.getName());
			pstmt.setInt(2, empObj.getAge());
			pstmt.setString(3, empObj.getDesignation());
			pstmt.setString(4, empObj.getDepartment());
			pstmt.setString(5, empObj.getCountry());
			pstmt.setInt(6, id);
			pstmt.executeUpdate();
			jdbcCon.commit();
			pstmt.close();
			System.out.println("\"An existing user was updated successfully!\")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean delete(int empId) {
		System.out.println("Please enter the employee id to delete ? ");
		int id = in.nextInt();
		try {
			String deleteQuery = "DELETE FROM employee WHERE id = " + id;
			pstmt = jdbcCon.prepareStatement(deleteQuery);
			int deleteCount = pstmt.executeUpdate();
			pstmt.close();
			System.out.println(deleteCount + " Employee(s) deleted");
			jdbcCon.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;

	}

	@Override
	public Employee get(int empId) throws EmployeeException {
		System.out.println("Please enter the employee id to get Employee data ");
		int id = in.nextInt();
		String selectQueryForEmpId = "SELECT * FROM jdbctraining.employee WHERE id=" + id;
		Employee emp = null;
		try {

			Statement stmt = jdbcCon.createStatement();
			rs = stmt.executeQuery(selectQueryForEmpId);

			while (rs.next()) {
				// Retrieve by column name
				id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");
				emp = new Employee(id, name, age, designation, department, country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
		}

	@Override
	public List<Employee> getAll() {
		List<Employee> empList = new ArrayList<Employee>();
		String selectQuery = "SELECT * FROM jdbctraining.employee";
		try {
			Statement stmt = jdbcCon.createStatement();
			rs = stmt.executeQuery(selectQuery);
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");
				empList.add(new Employee(id, name, age, designation, department, country));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}

	public void viewAll() {

		try {
			List<Employee> empList = getAll();
			if (!empList.isEmpty() && empList.size() > 0) {
				printHeader();
				for (Employee empListObj : empList) {
					System.out.println("\t" + empListObj.getEmpId() + "\t" + empListObj.getName() + "\t"
							+ empListObj.getAge() + "\t	" + empListObj.getDepartment() + "\t"
							+ empListObj.getDesignation() + "\t" + empListObj.getCountry());
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
				+ "\t" + "Country");
	}

	public void bulkImport() {
		System.out.println("Thread Name:" + Thread.currentThread().getName());
		String filePath = "input.txt";

		String line;
		BufferedReader reader = null;
		try {
			stmt = jdbcCon.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String insertQueryForPrepareStmt = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
		try {
			reader = new BufferedReader(new FileReader(filePath));
			try {
				System.out.println(reader.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			while ((line = reader.readLine()) != null) {
				System.out.println(line+"***********");
				
				String[] parts = line.split(",");
				System.out.println(line.split(",").toString());
				System.out.println(line.split(",").length);
				
				if (parts.length >= 0) {
					try {
//						stmt = jdbcCon.createStatement();
//						String insertQueryForPrepareStmt = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
						pstmt = jdbcCon.prepareStatement(insertQueryForPrepareStmt);
						pstmt.setString(1, parts[0]);
						pstmt.setInt(2, Integer.parseInt(parts[1]));
						pstmt.setString(3, parts[2]);
						pstmt.setString(4, parts[3]);
						pstmt.setString(5, parts[4]);
						int insertCount = pstmt.executeUpdate();
					    System.out.println(insertCount + " Employee(s) inserted");
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					System.out.println("ignoring line: " + line);
				}
				System.out.println("Bulk Import is success with the records size " + empList.size() + "!!!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				jdbcCon.commit();
			} catch (SQLException e) {				
				e.printStackTrace();
			}

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
					writer.write(empListObj.getCountry()+"");
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

	public void viewData(int empId) {
		try {
			Employee empObj = get(empId);
			if (empObj != null) {
				System.out
						.println("\t" + empObj.getEmpId() + "\t" + empObj.getName() + "\t" + empObj.getAge() + "\t	"
								+ empObj.getDepartment() + "\t" + empObj.getDesignation() + "\t" + empObj.getCountry());
			} else {
				System.out.println("There are no records to dispaly with the given employee id");
			}

		} catch (EmployeeException e) {
			e.printStackTrace();
		}

	}

}
