package com.imranmadbar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imranmadbar.admin.AdminService;
import com.imranmadbar.employee.EmployeeService;

@RestController
public class HomeController {

	@Autowired
	public AdminService adminService;
	
	@Autowired
	public EmployeeService employeeService;

	
	
	@GetMapping("/emp-info")
	public String getEmployeeInfo() {
		return employeeService.getInfo();
	}

	
	@GetMapping("/admin-info")
	public String getAdminInfo() {
		return adminService.getInfo();
	}
	
	
	
	
	
	@GetMapping("/")
	public String getHomeMsg() {
		return "Welcome to AOP application";
	}

}
