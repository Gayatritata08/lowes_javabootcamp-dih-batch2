package com.labs.springboot.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositry extends JpaRepository<Employee, empId> {
	
	
	//spring boot data starter
	//extends jparepositry
	
	
}
