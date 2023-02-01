package employee;
import java.sql.Connection;  
import java.sql.DriverManager;

public class JdbcCon {
	public Connection getConnection() throws Exception {
		DatabaseProperties db = new DatabaseProperties();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(db.getUrl(), db.getUsername(), db.getPassword());
		return con;
	}
	
}
