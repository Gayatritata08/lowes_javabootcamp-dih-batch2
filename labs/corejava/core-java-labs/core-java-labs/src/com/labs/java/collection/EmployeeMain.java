package com.labs.java.collection;

import java.util.ArrayList;
import java.util.Comparator;

public class EmployeeMain {

	public static void main(String[] args) {

		Employee emp = new Employee("Mark", 1, "IT-B");
		Employee emp1 = new Employee("Peter", 2, "IT-A");
		Employee emp2 = new Employee("John", 3, "IT-E");
		Employee emp3 = new Employee("David", 4, "ITOO");
		Employee emp4 = new Employee("Mike", 5, "ITPP");

		ArrayList<Employee> employee = new ArrayList<Employee>();
		employee.add(emp);
		employee.add(emp1);
		employee.add(emp2);
		employee.add(emp3);
		employee.add(emp4);

		for (Employee empObj : employee)
			System.out.println(empObj.toString());

		Comparator<Object> EMP_NAME_COMPARATOR = new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Employee && o2 instanceof Employee) {
					return ((Employee) o1).getName().compareTo(((Employee) o2).getName());
				}
				return 0;
			}

		};

		Comparator<Employee> EMP_NAME_AGE = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1 instanceof Employee && o2 instanceof Employee) {
					return o1.getId() - o2.getId();
				}
				return 0;

			}

		};
		
		System.out.println("After sorting----------");
		
		employee.sort(EMP_NAME_COMPARATOR);
		
		for (Employee empObj : employee)
			System.out.println(empObj.toString());

	}

}