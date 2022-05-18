package com.labs.oops;

class Student {

	public int rollNumber;
	public String name;
	static String schoolName = "ABC School";
}

public class StaticDemo {

	public static void main(String[] args) {
		Student sobj1 = new Student();
		sobj1.name = "Mark";
		sobj1.rollNumber = 356;

		System.out.println("name " + sobj1.name + "rollNumber " + sobj1.rollNumber +"School Name " + Student.schoolName);

		
		Student sobj2 =new Student();
        sobj2.name="Paul";
        sobj2.rollNumber=789;
        
        System.out.println("name " + sobj2.name + "rollNumber " + sobj2.rollNumber +"School Name " +Student.schoolName);
	}

}
