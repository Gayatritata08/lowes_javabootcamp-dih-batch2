package com.labs.oops;

public abstract class Person1 {

	private int age;
	private String gender;
	private String name;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person1 [age=" + age + ", gender=" + gender + ", name=" + name + "]";
	}

	public Person1(int age, String gender, String name) {

		this.age = age;
		this.gender = gender;
		this.name = name;
	}
	
	protected void printDetails() {
		System.out.println("Printing Person Details");
		System.out.println("name" + this.name);
		System.out.println("gender" + this.gender);
		System.out.println("age" + this.age);
		
	}
	
	public  void sayHello() {
		System.out.println("Hello Person1 class");
		
	}
	

}
