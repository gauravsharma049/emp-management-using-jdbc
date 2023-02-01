package employee;

public class DatabaseProperties {
	private final String url;
	private final String username;
	private final String password;
	public DatabaseProperties() {
		super();
		this.url = "jdbc:mysql://localhost:3306/employee";
		this.username = "root";
		this.password = "root";
	}
	public String getUrl() {
		return url;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	
}
