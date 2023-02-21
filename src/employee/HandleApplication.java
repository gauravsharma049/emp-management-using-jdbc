package employee;

import java.util.Scanner;

public class HandleApplication {
	private Scanner sc = new Scanner(System.in);
	private EmployeeService employeeService = new EmployeeService();
	public HandleApplication() {
		for(int i=0; i>=0; i++) {
			executeApplication();
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				
			}
		}
	}
	
	public void executeApplication() {
		System.out.println("\nWhat do you want to perform?");
		System.out.println("Enter the corresponding values according to your need...");
		System.out.println("Add Employee: 1 \nList all employee: 2 \nget employee by id: 3 \nupdate employee: 4 \ndelete employee: 5 \n");
		
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1: {
			addEmployee();
			break;
		}
		case 2:{
			getAllEmployee();
			break;
		}
		case 3:{
			getEmployeeById();
			break;
		}
		case 4:{
			updateEmployee();
			break;
		}
		case 5:{
			deleteEmployee();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		
		
	}
	
	public void addEmployee() {
		Employee emp = new Employee();
		System.out.println("enter emp id");
		emp.setId(sc.nextInt());
		sc.nextLine();
		System.out.println("enter emp name");
		emp.setName(sc.nextLine());
		System.out.println("enter emp age");
		emp.setAge(sc.nextInt());
		sc.nextLine();
		System.out.println("enter emp designation");
		emp.setDesignation(sc.nextLine());
		System.out.println("enter emp salary");
		emp.setSalary(sc.nextInt());
		System.out.println(employeeService.addEmployee(emp));;
	}
	
	public void getAllEmployee() {
		for(Employee e : employeeService.getAllEmployee()) {
			System.out.println(e);
		}
	}
	public void getEmployeeById() {
		System.out.println("Enter employee id:-");
		int id = sc.nextInt();
		System.out.println(employeeService.getEmployeeById(id));
	}
	
	public void deleteEmployee() {
		System.out.println("enter the id of employee you want to delete:-");
		int id = sc.nextInt();
		employeeService.deleteEmployee(id);
	}
	public void updateEmployee() {
		System.out.println("Enter the id of the employee you want to update:-");
		int id = sc.nextInt();
		Employee emp = employeeService.getEmployeeById(id);
		System.out.println("Enter the value respective to the value you want to update");
		System.out.println("id: 1 \nname: 2 \nage: 3 \ndesignation: 4 \nsalary: 5");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("Enter new id:");
			emp.setId(sc.nextInt());
			break;
		}
		case 2: {
			System.out.println("Enter new name:");
			sc.nextLine();
			emp.setName(sc.nextLine());
			break;
		}
		case 3: {
			System.out.println("Enter updated age:");
			emp.setAge(sc.nextInt());
			break;
		}
		case 4: {
			System.out.println("Enter new designation:");
			sc.nextLine();
			emp.setDesignation(sc.nextLine());
			break;
		}
		case 5: {
			System.out.println("Enter updated salary:");
			emp.setSalary(sc.nextInt());
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		System.out.println(employeeService.updateEmployee(id, emp));
		System.out.println("employee updated");
	}

}
