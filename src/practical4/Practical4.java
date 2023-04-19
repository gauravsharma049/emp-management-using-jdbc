package practical4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practical4 {
	public static List<Employee> getAllEmployee(Connection connection) {
		String query = "select * from emp";
		ArrayList<Employee> employees = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return employees;
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
			System.out.println(getAllEmployee(con));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
		
	}
}
