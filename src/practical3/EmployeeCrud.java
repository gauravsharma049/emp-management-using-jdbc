package practical3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeCrud {
	
	public static void getEmployeeById(Connection connection, int id) {
		String query="select * from emp where emp_id="+id;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			String queriedEmp = "";
			while(rs.next()) {
				queriedEmp = "Employee [id="+rs.getInt(1)+", name="+rs.getString(2)+", age="+rs.getInt(3)+", designation="+rs.getString(4)+", salary="+rs.getInt(5)+"]";
				System.out.println(queriedEmp);
			}
			
			if(queriedEmp.isEmpty()) {
				System.out.println("employee not found!");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void deleteEmployee(Connection connection, int id) {
		String query = "delete from emp where emp_id="+id;
		try {
			Statement st = connection.createStatement();
			int update = st.executeUpdate(query);
			if(update >0)
				System.out.println("employee deleted succefully");
			else
				System.out.println("employee doesn't exist!");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void updateEmployee(Connection connection, int id, Scanner sc) {
		System.out.println("what do you want to update?");
		System.out.println("update id : 1 \nenter 1 to update name \nenter 2 to update age  \n enter 3 to update designation \nenter 4 to update salary\n");
		int choice = sc.nextInt();
		String q="";
		PreparedStatement stmt=null;
		try {
			switch (choice) {
			case 1: {
				q = "update emp set emp_id =? where emp_id ="+id;
				stmt = connection.prepareStatement(q);
				System.out.println("Enter updated id :");
				stmt.setInt(1, sc.nextInt());
				break;
			}
			case 2:
				q = "update emp set name =? where emp_id ="+id;
				stmt = connection.prepareStatement(q);
				System.out.println("Enter updated name :");
				sc.nextLine();
				stmt.setString(1, sc.nextLine());
				break;
			
			case 3:
				q = "update emp set age =? where emp_id ="+id;
				stmt = connection.prepareStatement(q);
				System.out.println("Enter updated age :");
				stmt.setInt(1, sc.nextInt());
				break;
			
			case 4:
				q = "update emp set designation =? where emp_id ="+id;
				stmt = connection.prepareStatement(q);
				System.out.println("Enter updated designation :");
				sc.nextLine();
				stmt.setString(1, sc.nextLine());
				break;
			
			case 5:
				q = "update emp set salary =? where emp_id ="+id;
				stmt = connection.prepareStatement(q);
				System.out.println("Enter updated salary :");
				stmt.setInt(1, sc.nextInt());
				break;
			default:
				System.out.println("Unexpected value: " + choice);
			}
			
			stmt.execute();
			if(stmt.getUpdateCount()>0)
				System.out.println("employee updated");
			else
				System.out.println("employee doesn't exists");
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/employee";
		String username = "root";
		String password = "root";
		
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("enter 1 toretrive employee by id \nenter 2 to update employee by id \nenter 3 delete employee by id \n");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("enter employee id");
			getEmployeeById(con, sc.nextInt());
			break;
		}
		case 2:{
			System.out.println("enter employee id");
			updateEmployee(con, sc.nextInt(), sc);
			break;
		}
		
		case 3:{
			System.out.println("enter employee id");
			deleteEmployee(con, sc.nextInt());
			break;
		}
		default:
			System.out.println("Unexpected value: " + choice);
			break;
		}
		sc.close();
		
	}
}
