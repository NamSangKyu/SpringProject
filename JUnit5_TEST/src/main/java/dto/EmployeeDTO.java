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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((eno == null) ? 0 : eno.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + position;
		result = prime * result + ((positionName == null) ? 0 : positionName.hashCode());
		result = prime * result + salary;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("EmployeeDTO equals");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (eno == null) {
			if (other.eno != null)
				return false;
		} else if (!eno.equals(other.eno))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position != other.position)
			return false;
		if (positionName == null) {
			if (other.positionName != null)
				return false;
		} else if (!positionName.equals(other.positionName))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [eno=" + eno + ", name=" + name + ", department=" + department + ", position=" + position
				+ "]";
	}
	
	
	
}
