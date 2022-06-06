package com.assignment.empapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.assignment.empapp.dao.EmployeeDao;
import com.assignment.empapp.dao.EmployeeDaoImpl;
import com.assignment.empapp.model.Employee;
import com.assignment.empapp.service.EmployeeService;
import com.assignment.empapp.service.EmployeeServiceImpl;

@Configuration
public class EmployeeMgmtWithJavaConfig {
	@Bean(name = { "dataSource" })
	public DriverManagerDataSource getDataSource() {		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/jdbctraining");
		dataSource.setUsername("training");
		dataSource.setPassword("training");

		return dataSource;

	}

	@Bean(name = { "jdbcTemplate" })
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}

	@Bean(name = { "employeeDao" })
	public EmployeeDao getEmployeeDao() {
		EmployeeDaoImpl empDao = new EmployeeDaoImpl();
		empDao.setJdbcTemplate(getJdbcTemplate());
		return (EmployeeDao) empDao;
	}

	@Bean(name = "eService")
	public EmployeeService getEmpServiceImpl() {
		return new EmployeeServiceImpl();
	}

	@Bean(name = "emp")
	public Employee getEmployee() {
		return new Employee();
	}

}
