package employee2;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcConnection {
	public static void addEmployee(Connection connection, Scanner sc) {
		try {
			String query = "insert into emp values(?, ?, ?, ?, ?);";
			PreparedStatement stmt = connection.prepareStatement(query);
			System.out.println("Enter employee id :");
			stmt.setInt(1, sc.nextInt());
			System.out.println("Enter employee name :");
			sc.nextLine();
			stmt.setString(2, sc.nextLine());
			System.out.println("Enter employee age :");
			stmt.setInt(3, sc.nextInt());
			sc.nextLine();
			System.out.println("Enter employee designation :");
			stmt.setString(4, sc.nextLine());
			System.out.println("Enter employee salary :");
			stmt.setInt(5, sc.nextInt());
			stmt.execute();
			System.out.println("employee added successfully");
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
	}
	public static void getAllEmployee(Connection connection) {
		String query = "select * from emp";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				System.out.println("Employee [id="+rs.getInt(1)+", name="+rs.getString(2)+", age="+rs.getInt(3)+", designation="+rs.getString(4)+", salary="+rs.getInt(5)+"]");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
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
		System.out.println("add emp: 1 \nselect all emp: 2\n");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			addEmployee(con, sc);
			break;
		}
		
		default:
			System.out.println("Unexpected value: " + choice);
		}
		sc.close();
		
	}
}
