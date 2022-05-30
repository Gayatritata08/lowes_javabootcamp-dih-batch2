/* 1. We can have one null also but allow duplicate values
 * 2. Its not ordered
 */

package com.labs.java.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetDemo {
	// HashSet
	public static <E> void main(String[] args) {
		HashSet<String> countries = new HashSet<String>();

		countries.add("India");
		countries.add("China");
		countries.add("Japan");
		countries.add("Sri lanka");
		countries.add("Russia");
		countries.add("India");

		countries.add(null);
		countries.add(null);

		for (String str : countries)
			System.out.println("" + str);

		// TreeSet
		/*
		 * Data should get in sorted so null should not give... it should do
		 * comparision.
		 */
	
			
		
		System.out.println("*TreeSet");
		TreeSet<String> countries1 = new TreeSet<String>();
		
		countries1.add("India");
		countries1.add("China");
		countries1.add("Japan");
		countries1.add("Sri lanka");
		countries1.add("Russia");
		countries1.add("India");

		// countries1.add(null);
		// countries1.add(null);

		for (String str : countries1)
			System.out.println("" + str);

		HashSet<Employee> setEmployee = new HashSet<Employee>();
		
		Employee emp = new Employee("John", 123, "Id");
		Employee emp1= new Employee("Mark", 123, "IIY");
		Employee emp2 = new Employee("David", 45534, "IId");
		
		setEmployee.add(emp);
		setEmployee.add(emp1);
		setEmployee.add(emp2);
		
		/*
		 * Comparator<Employee> employeeComparator = new Comparator<Employee>() {
		 * 
		 * @Override public int compare(Employee emp1,Employee emp2){ return
		 * emp1.getId() - emp2.getId()+ emp.getName() - emp2.getName(); } };
		 */
		
		for(Employee empObj:setEmployee)
			System.out.println(empObj);
	}

}
