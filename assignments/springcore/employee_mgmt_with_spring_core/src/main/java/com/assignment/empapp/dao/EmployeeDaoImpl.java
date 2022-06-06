package com.assignment.empapp.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.assignment.empapp.exception.EmployeeException;
import com.assignment.empapp.model.Employee;
import com.assignment.empapp.service.EmployeeServiceImpl;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean create(Employee emp) throws EmployeeException {
		String sql = "INSERT INTO employee (name, age, designation, department, country,doj,createdTime) VALUES (?, ?, ?, ?, ?,?,?)";
		Object[] arg = { emp.getName(), emp.getAge(), emp.getDesignation(), emp.getDepartment(), emp.getCountry(),
				Date.valueOf(emp.getDoj()), Timestamp.valueOf(LocalDateTime.now()) };

		int noOfRowsInserted = jdbcTemplate.update(sql, arg);
		System.out.println(noOfRowsInserted + " Employee record has been created");
		
		return noOfRowsInserted > 0;
	}

	@Override
	public boolean update(Employee emp) throws EmployeeException {		
		String sql = "UPDATE employee SET name=?,age=?,designation=?,department=?,country=?,doj=?,modifiedTime=? WHERE id=?";
		Object[] arg = { emp.getName(), emp.getAge(), emp.getDesignation(), emp.getDepartment(), emp.getCountry(),
				emp.getDoj(), Timestamp.valueOf(LocalDateTime.now()), emp.getEmpId() };
		int noOfRowsUpdated = jdbcTemplate.update(sql, arg);
		System.out.println("\"An existing user was updated successfully!\")");
		return noOfRowsUpdated == 1;
	}

	@Override
	public boolean delete(int empId) {
		String deleteQuery = "DELETE FROM employee WHERE id = ?";
		int noOfRowsDeleted = jdbcTemplate.update(deleteQuery, empId);
		return noOfRowsDeleted == 1;
	}

	@Override
	public Employee get(int empId) throws EmployeeException {
		String selectQueryForEmpId = "SELECT * FROM jdbctraining.employee WHERE id="+empId;
		Employee emp = jdbcTemplate.queryForObject(selectQueryForEmpId, new EmployeeRowMapper());
		return emp;
	}

	@Override
	public List<Employee> getAll() {
		String selectSql = "SELECT * FROM jdbctraining.employee";
		List <Employee> empList  =jdbcTemplate.query(selectSql, new EmployeeRowMapper());
		return empList;
	}

}
