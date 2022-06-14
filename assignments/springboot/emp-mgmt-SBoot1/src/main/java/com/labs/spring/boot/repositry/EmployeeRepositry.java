package com.labs.spring.boot.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labs.spring.boot.Entity.Employee;
@Repository
public interface EmployeeRepositry extends JpaRepository<Employee, Integer> {

}
