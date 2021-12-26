package com.imranmadbar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imranmadbar.employee.EmployeeDto;
import com.imranmadbar.employee.EmployeeEntity;

@RestController
@RequestMapping("/beanscope")
public class BeanScopeController {
	
	@Autowired
	private EmployeeEntity emp1;
	
	@Autowired
	private EmployeeEntity emp2;

	@GetMapping("/")
	public String getHomeMsg() {
		return "Welcome to bean scope Controller";
	}

	@GetMapping("/sc1")
	public String scOne() {

		emp1.setId(1);

		emp2.setId(2);

		System.out.println(emp1);
		System.out.println(emp2);

		return "This msg from sc1";
	}

	@GetMapping("/sc2")
	public String scTwo() {

	
		emp1.setId(1);

		EmployeeEntity emp2 = new EmployeeEntity();
		emp2.setId(2);

		System.out.println(emp1);
		System.out.println(emp2);

		return "This msg from sc2";
	}

}
