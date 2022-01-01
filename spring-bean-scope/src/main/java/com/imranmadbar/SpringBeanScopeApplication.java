package com.imranmadbar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBeanScopeApplication {

	public static void main(String... args) {

		ApplicationContext context = SpringApplication.run(SpringBeanScopeApplication.class, args);

//		EmployeeDto emp1 = context.getBean(EmployeeDto.class);
//		EmployeeDto emp2 = context.getBean(EmployeeDto.class);
//
//		System.out.println(emp1);
//		System.out.println(emp2);

	}
}
