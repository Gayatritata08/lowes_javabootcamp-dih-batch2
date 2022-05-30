package com.labs.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class CollectionGeneric {

	public static void main(String args[]) {
		// List
		System.out.println("1.Array Lsit");
		ArrayList<String> list = new ArrayList<String>();

		list.add("India");
		list.add("Indonesia");
		list.add("China");
		list.add("Sri lanka");
		list.add("Japan");
		list.add("USA");

		// approach 1
		for (String countries : list) {
			System.out.println(countries);
		}

		// approach2
		System.out.println("Using liste iterator traverse------------");
		Iterator<String> itr = list.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());

		Employee emp0 = new Employee("Mike", 50, "UYTIT");
		Employee emp1 = new Employee("Paul", 20, "WQEIT");
		Employee emp2 = new Employee("Henry", 40, "FSDIT");
		Employee emp3 = new Employee("Zoden", 39, "IYTT");
		Employee emp4 = new Employee("Aviral", 45, "SSIT");

		ArrayList<Employee> employee = new ArrayList<Employee>();
		employee.add(emp0);
		employee.add(emp1);
		employee.add(emp2);
		employee.add(emp3);
		employee.add(emp4);
		System.out.println("Before sorting");
		for (Employee empObject : employee) {
			System.out.println(empObject.toString());
		}
		// Sorting based on Age,Name,desingnation

		Comparator<Object> SORT_EMP_NAME = new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Employee && o2 instanceof Employee) {
					return (((Employee) o1).getName().compareTo(((Employee) o2).getName()));

				}

				return 0;

			}

		};
		
		Comparator<Object> SORT_EMP_AGE = new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Employee && o2 instanceof Employee) {
					return (((Employee) o1).getName().compareTo(((Employee) o2).getName()));

				}

				return 0;

			}

		};

//		Comparator<Object> EMP_NAME_COMPARATOR = new Comparator<Object>() {
//			public int compare(Object o1, Object o2) {
//				if (o1 instanceof Employee && o2 instanceof Employee) {
//					return ((Employee) o1).getName().compareTo(((Employee) o2).getName());
//				}
//				return 0;
//			}
//
//		};

		Collections.sort(employee, SORT_EMP_NAME);
		System.out.println("After sorting");
		// after sorting

		for (Employee empObject : employee) {
			System.out.println(empObject.toString());
		}

	}

}
