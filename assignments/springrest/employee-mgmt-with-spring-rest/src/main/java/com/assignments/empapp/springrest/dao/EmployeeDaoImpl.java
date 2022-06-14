package com.assignments.empapp.springrest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.assignments.empapp.springrest.exception.EmployeeException;
import com.assignments.empapp.springrest.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	public JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Employee create(Employee emp) throws EmployeeException {

		String sql = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
		Object[] arg = { emp.getName(), emp.getAge(), emp.getDesignation(), emp.getDepartment(), emp.getCountry() };
		int noOfRowsInserted = jdbcTemplate.update(sql, arg);

		System.out.println(noOfRowsInserted + " Employee record has been created");

		return emp;

	}

	public Employee update(int empId, Employee emp) throws EmployeeException {
		String sql = "UPDATE employee SET name=?,age=?,designation=?,department=?,country=? WHERE id=?";
		Object[] arg = { emp.getName(), emp.getAge(), emp.getDesignation(), emp.getDepartment(), emp.getCountry(),
				empId };
		int noOfRowsUpdated = jdbcTemplate.update(sql, arg);
		System.out.println(noOfRowsUpdated + "\"An existing user was updated successfully!\")");
		return emp;
	}

	public boolean delete(int empId) {
		String deleteQuery = "DELETE FROM employee WHERE id = ?";
		int noOfRowsDeleted = jdbcTemplate.update(deleteQuery, empId);
		return noOfRowsDeleted == 1;
	}

	public Employee get(int empId) throws EmployeeException {
		String selectQueryForEmpId = "SELECT * FROM jdbctraining.employee WHERE id=" + empId;
		Employee emp = jdbcTemplate.queryForObject(selectQueryForEmpId, new EmployeeRowMapper());
		return emp;
	}

	public List<Employee> getAll() {
		String selectSql = "SELECT * FROM jdbctraining.employee";
		List<Employee> empList = jdbcTemplate.query(selectSql, new EmployeeRowMapper());
		return empList;
	}

}
