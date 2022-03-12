package com.imranmadbar;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringRESTfulServiceOPApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringRESTfulServiceOPApplication.class, args);
		System.out.println("Spring Boot Web Application Run Successfully Done !");
	}

}
