package com.imranmadbar.employee;

public class EmployeeEntity {
	
private int id;
	
	private String empName;
	
	private String empCity;
	
	private float empSalary;
	
	
	public EmployeeEntity() {}
	
	
	public EmployeeEntity(int id, String empName, String empCity, float empSalary) {
		this.id = id;
		this.empName = empName;
		this.empCity = empCity;
		this.empSalary = empSalary;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	public float getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}


	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", empName=" + empName + ", empCity=" + empCity + ", empSalary=" + empSalary
				+ "]";
	}
	
	

}
