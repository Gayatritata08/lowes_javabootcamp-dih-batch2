package com.sboot.empapp.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sboot.empapp.model.Employee;


public interface EmployeeRepositry extends JpaRepository<Employee, Integer> {

}
