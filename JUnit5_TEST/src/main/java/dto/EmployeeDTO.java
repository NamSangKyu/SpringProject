package dto;

public class EmployeeDTO {
	private String eno;
	private String name;
	private String department;
	private int position;
	private String positionName;
	private int salary;
	
	public EmployeeDTO(String eno, String name, String department, String positionName, int salary, int position) {
		super();
		this.eno = eno;
		this.name = name;
		this.department = department;
		this.positionName = positionName;
		this.salary = salary;
		this.position = position;
	}
	public EmployeeDTO(String eno, String name, String department, int position) {
		super();
		this.eno = eno;
		this.name = name;
		this.department = department;
		this.position = position;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [eno=" + eno + ", name=" + name + ", department=" + department + ", position=" + position
				+ "]";
	}
	
	
	
}
