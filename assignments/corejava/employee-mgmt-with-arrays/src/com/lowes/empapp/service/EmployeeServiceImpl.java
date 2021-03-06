package com.lowes.empapp.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.lowes.empapp.exception.EmployeeException;
import com.lowes.empapp.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	Scanner sc = new Scanner(System.in);

	 Employee[] emp = new Employee[10];	 
	
	static int index=0;
	public void insertEmpData() throws InputMismatchException, EmployeeException {

		try {			
			if(index !=10) {
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

			emp[index++] = new Employee(empId, empName, empAge, empDesig, empDept);
			System.out.println("Inserted employee data successfully ");			
			System.out.println(index);
					
	     
			} else {
				System.out.println("Array size is full. We can not add data");
			}
		}catch(Exception e) {
			new EmployeeException("Please check InsertEmpData method.");
			e.printStackTrace();
		}

	}

	public void updateEmpData() {
		try {
			boolean empStatus = false;
			int empId=0;
			do {
				System.out.println("Please enter the employee id which you want to update : ");
                if(sc.hasNext())
				empId= sc.nextInt() ;
				for (Employee empObj : emp) {
					if (empObj != null && empObj.getEmpId() == empId) {
						System.out.println("Please enter employee name");
						String empName = sc.next();
						empObj.setName(empName);

						System.out.println("Please enter employee age");
						int empAge = sc.nextInt();
						empObj.setAge(empAge);

						System.out.println("Please enter employee designation");
						String empDesig = sc.next();
						empObj.setDesignation(empDesig);

						System.out.println("Please enter employee department");
						String empDept = sc.next();
						empObj.setDepartment(empDept);
						
						empStatus = true;
                     System.out.println("Employee Updated Successfully");
					}

				}
				
				if (empStatus == false) {
					System.out.println("Given employee id is not found.please enter valid input");
				}
			} while (empStatus != true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteEmpData() {
		System.out.println("Please enter the employee id which you want to delete : ");
		boolean status = false;
        int deletedIndex = 0;
		try {
			int empId = sc.nextInt();
			System.out.println("Employee Data after delete the specified record :");
			for (int i = 0; i < emp.length; i++) {
	            if (emp[i] != null) {
	                if (emp[i].getEmpId() == empId) {
	                    emp[i] = null;
	                    deletedIndex = i;
	                    index--;
	                    status = true;
	                    break;
	                }
	            }
	        } if (status) {  // shifting the elements upwards
	            for (int i = deletedIndex; i < emp.length; i++) {
	                if ((i + 1) >= emp.length) {  // when we get last element, make it null
	                    emp[i] = null;
	                    break;
	                } else {
	                    emp[i] = emp[i + 1];  // shift the element to upwaards
	                }
	            }
	        } else {
	            System.out.println("Employee was not found ");
	        }
			
		} catch(Exception e) {
			new EmployeeException("Please check delete method.");
			e.printStackTrace();
		}
			
			}

			public void viewEmployeData() throws InputMismatchException, EmployeeException {
				try {
					boolean empStatus = false;
					do {
						System.out.println("Please enter the employee id which you want to view : ");

						int empId = sc.nextInt();
						for (Employee empObj : emp) {
							if (empObj != null && empObj.getEmpId() == empId) {
								printHeader();
								System.out.println("\t      " + empObj.getEmpId() + "\t    " + empObj.getName()
										+ "\t    " + empObj.getAge() + "\t      " + empObj.getDesignation() + "\t      "
										+ empObj.getDepartment());

								empStatus = true;

							}

						}
						if (empStatus == false) {
							System.out.println("Given employee id is not found.please enter valid input");
						}
					} while (empStatus != true);

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
