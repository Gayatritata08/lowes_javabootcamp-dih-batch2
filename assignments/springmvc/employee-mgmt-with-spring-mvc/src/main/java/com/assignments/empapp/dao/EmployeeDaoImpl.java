package com.assignments.empapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.assignments.empapp.model.Employee;

@Repository
@Qualifier("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	// public static DataSource dataSource;

	@Autowired
	DataSource dataSource;

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// inserted using constructor injection.
	public EmployeeDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;

		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection created successfully " + conn);
	}

	public void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean createEmployee(Employee emp) {
		boolean status = false;
		try {
			stmt = conn.createStatement();

			String query = "INSERT INTO employee (name,age,designation,department,country) VALUES(\"" + emp.getName()
					+ "\"," + emp.getAge() + ",\"" + emp.getDesignation() + "\",\"" + emp.getDepartment() + "\",\""
					+ emp.getCountry() + "\")";
			status = stmt.execute(query);

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("Error occurred while inserting Employee data");
		}

		return status;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		boolean status = false;
		try {
			stmt = conn.createStatement();

			String query = "UPDATE employee SET name = \"" + emp.getName() + "\", age = " + emp.getAge()
					+ " ,designation = \"" + emp.getDesignation() + "\" ,department = \"" + emp.getDepartment()
					+ "\",country=\"" + emp.getCountry() + "\" WHERE id = " + emp.getId();
			status = stmt.execute(query);

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("Error occurred while Updating Employee data");
		}
		return status;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean status = false;
		try {
			stmt = conn.createStatement();

			String query = "DELETE FROM employee WHERE id = " + empId;
			status = stmt.execute(query);

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("Error occurred while deleting Employee data");
		}
		return status;
	}

	@Override
	public Employee get(int empId) {
		Employee emp = null;
		String query = "SELECT * FROM employee WHERE id = " + empId;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");
				// LocalDate doj = rs.getDate("dateofjoining").toLocalDate();

				emp = new Employee(id, name, age, designation, department, country);

			}

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("This employee does not exist!");
		}

		return emp;
	}

	@Override
	public List<Employee> displayEmployees() {

		List<Employee> employees = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employee");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");
				// LocalDate doj = rs.getDate("dateofjoining").toLocalDate();

				employees.add(new Employee(id, name, age, designation, department, country));
			}

		} catch (SQLException e) {
			// e.printStackTrace();

			System.out.println("Error occurred while getting all the Employee data");
		}

		return employees;

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}