package com.lowes.empapp;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.lowes.empapp.exception.EmployeeException;
import com.lowes.empapp.service.EmployeeServiceImpl;

public class EmployeeMain {

	public static void main(String[] args) throws EmployeeException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your choice:");
		int choice;
		EmployeeServiceImpl eService = new EmployeeServiceImpl();

		System.out.println(
				"***Welcome to Employee Management Application*****" + "\n 1. Add Employee" + "\n 2. view Employee"
						+ "\n 3. Update Employee" + "\n 4. Delete Employee" + "\n 5. view All Employee" + "\n 6. Exit");
		try {
			do {

				System.out.println("Please enter your choice:");
				choice = sc.nextInt();
				switch (choice) {

				case 1:
					System.out.println("Add Emplyee :");
					eService.insertEmpData();
					break;
				case 2:
					System.out.println("view Employee :");
					eService.viewEmployeData();
					break;
				case 3:
					System.out.println("Update Employee :");
					eService.updateEmpData();
					break;
				case 4:
					System.out.println("Delete Employee :");
					eService.deleteEmpData();
					break;
				case 5:
					System.out.println("view All Employee :");
					eService.viewAllEmpData();
					break;
				case 6:
					System.out.println("Thank you for using the application");
					System.exit(0);
					break;
				default:
					System.out.println("Please Enter Valid Input");
					break;

				}
			} while (choice != 0);
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} catch (EmployeeException e) {
			throw new EmployeeException("Please provide employee data");
		}

	}
}