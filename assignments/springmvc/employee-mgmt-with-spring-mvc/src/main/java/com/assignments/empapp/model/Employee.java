package com.assignments.empapp.model;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private int id;
	private String name;
	private Integer age = null;

	private String designation;
	private String department;

	private String country;

	// default constructor
	public Employee() {

		// this(101, "Hema", 24, "Developer", "IT", "India", "28/05/2022");

	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + age + "\t" + designation + "\t" + department + "\t" + country;

	}

	public Employee(int id, String name, int age, String designation, String department, String country) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.department = department;
		this.country = country;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
