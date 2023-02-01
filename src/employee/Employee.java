package employee;

public class Employee {
	private int id;
	private String name;
	private int age;
	private String designation;
	private int salary;
	public Employee(int id, String name, int age, String designation, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.salary = salary;
	}
	public Employee() {
		super();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", designation=" + designation + ", salary="
				+ salary + "]";
	}
	
	
}
