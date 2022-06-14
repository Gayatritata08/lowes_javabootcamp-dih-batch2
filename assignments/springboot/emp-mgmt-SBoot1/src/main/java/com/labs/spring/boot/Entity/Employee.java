package com.labs.spring.boot.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue
	int id;
	@NotEmpty(message = "Name field cannot be null or empty.")
	@NotNull(message = "Name field cannot be null or empty.")
	@Size(max = 20, message = "Name should not exceed more than 20 chars")
	String name;
	@NotNull(message = "Age field cannot be null or empty.")
	@Min(18)
	@Max(60)
	@PositiveOrZero
	int age;
	String designation;

	String department;

	String country;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public Employee() {
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

}