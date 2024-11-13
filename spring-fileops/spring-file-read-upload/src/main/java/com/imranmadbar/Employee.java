package com.imranmadbar;

import java.time.LocalDate;

public class Employee {

	private Long employeeId;

	private String firstName;

	private String lastName;

	private LocalDate startedDateInCompany;

	public Employee() {
	}
	
	public Employee(Long employeeId, String firstName, String lastName, LocalDate startedDateInCompany) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.startedDateInCompany = startedDateInCompany;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getStartedDateInCompany() {
		return startedDateInCompany;
	}

	public void setStartedDateInCompany(LocalDate startedDateInCompany) {
		this.startedDateInCompany = startedDateInCompany;
	}

}
