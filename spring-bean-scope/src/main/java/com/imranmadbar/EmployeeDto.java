package com.imranmadbar;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@SessionScope
//@RequestScope
@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeeDto {

	private int id;

	private String empName;

	public EmployeeDto() {
	}

	public EmployeeDto(int id, String empName) {
		this.id = id;
		this.empName = empName;
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

	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", empName=" + empName+"]";
	}

}
