package com.lowes.empapp;

import java.util.InputMismatchException;
import java.util.Scanner;

class EmployeeService {
	
	Scanner sc = new Scanner(System.in);

	 Employee[] emp = new Employee[10];
	 
	 /*
	  *  { 
			new Employee(35927, "Mark henry", 35, "SE", "IT"),
			new Employee(34927, "Paul henry", 35, "SE", "IT"),
			new Employee(34237, "David paul", 36, "Junior", "Marketing"),
			new Employee(23237, "Peter KN", 36, "consultant", "IT-A"),
			new Employee(53457, "Bell GH", 38, "Operator", "IT-B"),
			new Employee(31227, "Mike JD", 25, "SSE", "IT-C") };
	  */
	static int index=0;
	public void insertEmpData() throws InputMismatchException, EmployeeException {

		try {			
			
			System.out.println("Please enter employee Id");
			int empId = sc.nextInt();

			System.out.println("Please enter employee name");
			String empName = sc.next();

			System.out.println("Please enter employee age");
			int empAge = sc.nextInt();

			System.out.println("Please enter employee designation");
			String empDesig = sc.next();

			System.out.println("Please enter employee department");
			String empDept = sc.next();

			emp[index] = new Employee(empId, empName, empAge, empDesig, empDept);
			System.out.println("" + emp[0].toString());
       
	     index++;
		}catch(Exception e) {
			new EmployeeException("Please check InsertEmpData method.");
			e.printStackTrace();
		}

	}

	public void updateEmpData() {
		System.out.println("Please enter the employee id which you want to update : ");
		try {
			int empId = sc.nextInt();
			if(empId !=0) { 
			for (int i = 0; i < emp.length; i++)
				if (emp[i].getEmpId() == empId) {
					System.out.println("Please enter employee name");
					String empName = sc.next();
					emp[i].setName(empName);

					System.out.println("Please enter employee age");
					int empAge = sc.nextInt();
					emp[i].setAge(empAge);

					System.out.println("Please enter employee designation");
					String empDesig = sc.next();
					emp[i].setDesignation(empDesig);

					System.out.println("Please enter employee department");
					String empDept = sc.next();
					emp[i].setDepartment(empDept);

				}
			}else {
				System.out.println("Please provide valid employee id");
			}
		} catch (Exception e) {		
			e.printStackTrace();
		}

	}

	public void deleteEmpData() {
		System.out.println("Please enter the employee id which you want to delete : ");
		try {
			int empId = sc.nextInt();
			System.out.println("Employee Data after delete the specified record :");
			printHeader();
			int n = emp.length;
			Employee[] tempEmp = new Employee[n];
			int j = 0;
					
					for (int i = 0; i < n - 1; i++) {
						if (emp[i].getEmpId() != empId) {
						tempEmp[j] = emp[i];
						j++;
						}					
					}	
					tempEmp[j++] =emp[n-1];
				
				// Changing original array
				for (int i = 0; i < j; i++) {
					emp[i] = tempEmp[i];
					
				}
				for (int i = 0; i < emp.length-1; i++) {
				System.out.println(
						"\t      " + emp[i].getEmpId() + "\t    " + emp[i].getName() + "\t    " + emp[i].getAge()
								+ "\t      " + emp[i].getDesignation() + "\t      " + emp[i].getDepartment());
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
			
			}
	

			public void viewEmployeData() throws InputMismatchException, EmployeeException {
				try {
					System.out.println("Please enter the employee id which you want to view : ");
					int empId = sc.nextInt();
					for (Employee empObj : emp)
						if (empObj != null && empObj.getEmpId() == empId) {
							printHeader();
							System.out.println("\t      " + empObj.getEmpId() + "\t    " + empObj.getName() + "\t    "
									+ empObj.getAge() + "\t      " + empObj.getDesignation() + "\t      "
									+ empObj.getDepartment());

						} else
							System.out.println("Please enter the valid employee Id ");
				} catch (InputMismatchException e) {
					throw new EmployeeException("InputMismatchException Please enter valid input");
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

	public void viewAllEmpData() {
		printHeader();
	for(Employee empObj : emp) { 
			if(empObj != null)
			System.out.println("\t" + empObj.getEmpId() + "\t        " + empObj.getName() + "\t    " + empObj.getAge()
					+ "\t      " + empObj.getDesignation() + "\t      " + empObj.getDepartment());
		}
		}



	public void printHeader() {
		System.out.println("\t" + "Emplyee Id" + "\t" + "Employee Name" + "\t" + "Emplyee Age" + "\t"
				+ "Employee Designation" + "\t" + "Employee Dept");
	}

}
