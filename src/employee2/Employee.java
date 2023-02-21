package employee2;

public class Employee {
	int emp_id;
	String name;
	int age;
	String designation;
	int salary;
	
	public Employee(int emp_id, String name, int age, String designation, int salary) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.salary = salary;
	}
	
	public Employee() {
		super();
		
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
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
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", age=" + age + ", designation=" + designation
				+ ", salary=" + salary + "]";
	}
	
	
	
}
