package employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
	JdbcCon jdbcCon = new JdbcCon();
	Connection connection;
	public EmployeeService() {
		try {
			this.connection = jdbcCon.getConnection();
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
	}
	
	public Employee addEmployee(Employee employee) {
		try {
			String query = "insert into emp values(?, ?, ?, ?, ?);";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, employee.getId());
			stmt.setString(2, employee.getName());
			stmt.setInt(3, employee.getAge());
			stmt.setString(4, employee.getDesignation());
			stmt.setInt(5, employee.getSalary());
			
			stmt.execute();
			System.out.println("employee added successfully");
			return employee;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public List<Employee> getAllEmployee() {
		List<Employee> employees = new ArrayList<>();
		String query = "select * from emp";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				employees.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5)));
			}
			return employees;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public Employee getEmployeeById(int id) {
		String query="select * from emp where emp_id="+id;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			return new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void deleteEmployee(int id) {
		String query = "delete from emp where emp_id="+id;
		try {
			Statement st = connection.createStatement();
			int update = st.executeUpdate(query);
			if(update >0)
				System.out.println("employee deleted succefully");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public Employee updateEmployee(int id, Employee emp) {
		String query = "update emp set emp_id="+emp.getId()+", name='"+emp.getName()+"', age="+emp.getAge()+", designation='"+emp.getDesignation()+"', salary=" +emp.getSalary()+" where emp_id="+id;
		try {
			Statement st = connection.createStatement();
			st.executeUpdate(query);
			
			return emp;
		}
		catch(Exception e) {
			System.out.println(e);
			return  null;
		}
	}
	
}
