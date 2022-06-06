package com.lowes.empapp.model;

/*D/W between constructor and Setter injection
1. Partial dependency - can be injected using setter injection , but it is not possible by constructor injection
2. Overriding  - setter injection override the constructor injection if we use both IOC will use setter
3. Change - we can easily change the value by setter injection, so setter injection is more flexible then the constructor injection
*/
public class Employee {

	private int empId;
	private String name;
	private int age;
	private String designation;
	private String department;
	private String country;

	/*
	 * public Employee() {
	 * 
	 * }
	 * 
	 * public Employee(int empId, String name, int age, String designation, String
	 * department, String country) { this.empId = empId; this.name = name; this.age
	 * = age; this.designation = designation; this.department = department;
	 * this.country = country; }
	 */

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", designation=" + designation
				+ ", department=" + department + " country=" + country + "]";
	}


    public void init(){
        System.out.println("init is called");
    }

    public void destroy(){
        System.out.println("destroy is called");
    }



}
