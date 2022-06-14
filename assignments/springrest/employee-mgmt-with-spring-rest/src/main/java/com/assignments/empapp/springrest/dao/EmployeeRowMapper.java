package com.assignments.empapp.springrest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.assignments.empapp.springrest.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee empObj = new Employee();
		empObj.setEmpId(rs.getInt("id"));
		empObj.setName(rs.getString("name"));
		empObj.setAge(rs.getInt("age"));
		empObj.setDepartment(rs.getString("department"));
		empObj.setDesignation(rs.getString("designation"));
		empObj.setCountry(rs.getString("country"));
		LocalDate doj;
		if (rs.getDate("doj") != null)
			doj = rs.getDate("doj").toLocalDate();
		else
			doj = null;
		LocalDateTime createdTime;
		if (rs.getDate("createdTime") != null)
			createdTime = rs.getTimestamp("createdTime").toLocalDateTime();
		else
			createdTime = null;
		LocalDateTime modifiedTime;
		if (rs.getDate("modifiedTime") != null)
			modifiedTime = rs.getTimestamp("modifiedTime").toLocalDateTime();
		else
			modifiedTime = null;

		empObj.setDoj(doj);
		empObj.setCreatedTime(createdTime);
		empObj.setModifiedTime(modifiedTime);

		return empObj;
	}

}
