package com.imranmadbar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imranmadbar.config.ApplicationContextHolder;

@RestController
public class BeanScopeController {
	
	

	@GetMapping("/sc1")
	public String scOne() {

		EmployeeDto emp1 = ApplicationContextHolder.getContext().getBean(EmployeeDto.class);
		emp1.setId(1);

		EmployeeDto emp2 = ApplicationContextHolder.getContext().getBean(EmployeeDto.class);
		emp2.setId(2);

		System.out.println(emp1);
		System.out.println(emp2);

		return "This msg from sc1";
	}

	@GetMapping("/sc2")
	public String scTwo() {

		EmployeeDto emp1 = ApplicationContextHolder.getContext().getBean(EmployeeDto.class);
		emp1.setId(1);

		EmployeeDto emp2 = ApplicationContextHolder.getContext().getBean(EmployeeDto.class);
		emp2.setId(2);

		System.out.println(emp1);
		System.out.println(emp2);

		return "This msg from sc2";
	}
	
	@GetMapping("/setbean")
	public String scTwo(@RequestParam String name) {

		EmployeeDto emp1 = ApplicationContextHolder.getContext().getBean(EmployeeDto.class);
		emp1.setId(1);
		emp1.setEmpName(name);


		System.out.println(emp1);

		return "This msg from sc2";
	}
	
	@GetMapping("/getbean")
	public String sc() {

		EmployeeDto emp1 = ApplicationContextHolder.getContext().getBean(EmployeeDto.class);
		System.out.println(emp1);
		return emp1.toString();
	}

	@GetMapping("/")
	public String getHomeMsg() {
		return "Welcome to bean scope Controller";
	}

}
