package com.imranmadbar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.imranmadbar.config.AppConfig;
import com.imranmadbar.employee.EmployeeEntity;

@SpringBootApplication
public class SpringBeanScopeApplication {

	public static void main(String... args) {
		SpringApplication.run(SpringBeanScopeApplication.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		EmployeeEntity emp1 = context.getBean("employeeObj", EmployeeEntity.class);
		emp1.setId(1);
		EmployeeEntity emp2 = context.getBean("employeeObj", EmployeeEntity.class);
		emp2.setId(2);

		System.out.println(emp1);
		System.out.println(emp2);

	}
}
