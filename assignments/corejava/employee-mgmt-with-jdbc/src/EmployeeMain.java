
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.lowes.empapp.model.Employee;
import com.lowes.empapp.service.EmployeeServiceImpl;

public class EmployeeMain {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int option = 0;
		System.out.println("**Welcome to Employee Managemet Application*** ");
		EmployeeServiceImpl eService = new EmployeeServiceImpl();
		ExecutorService service = Executors.newCachedThreadPool();

		Employee emp = new Employee();
		boolean status;
		while (true) {
			System.out.println("1.Create Employee");
			System.out.println("2.Update Employee");
			System.out.println("3.Delete Employee");
			System.out.println("4.View Employee");
			System.out.println("5.View All Employee");
			System.out.println("6.Import");
			System.out.println("7.Export");
			System.out.println("8.Exit");

			try {
				System.out.println("Please enter the option");
				option = Integer.parseInt(in.next());
			} catch (Exception e) {
				System.out.println("Please enter valid input");
				continue;
			}
			try {
				switch (option) {
				case 1:
					status = eService.create(emp);
					if (status == true) {
						System.out.println("Employee has been create successfully !!!");
					} else
						System.out.println("Employee has not created");
					break;
				case 2:
					status = eService.update(emp);
					if (status == true) {
						System.out.println("Employee has been updated successfully !!!");
					} else
						System.out.println("Employee has not updated");
					break;
				case 3:
					status = eService.delete(emp.getEmpId());
					if (status == true) {
						System.out.println("Employee has been deleted successfully !!!");
					} else
						System.out.println("Employee has not deleted");
					break;
				case 4:
					eService.viewData(emp.getEmpId());
					break;
				case 5:
					eService.viewAll();
					break;
				case 6:
					Future<Boolean> future = service.submit(new Callable<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							Thread.sleep(1000);
							 eService.bulkImport();
							//future.get();
							return true;
						}						
					});
					break;
				case 7:
					Future<Boolean> future1 = service.submit(new Callable<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							Thread.sleep(2000);
							eService.bulkExport();
							//future.get();
							return true;
						}						
					});						
					service.shutdown();
					break;
				case 8:
					System.exit(0);
					break;
				case 9:
					service.shutdown();
					break;
				default:
					System.out.println("Please Enter Valid Input");
					break;

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
