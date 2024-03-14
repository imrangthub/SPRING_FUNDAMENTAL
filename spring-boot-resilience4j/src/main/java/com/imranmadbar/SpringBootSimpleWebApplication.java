package com.imranmadbar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSimpleWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSimpleWebApplication.class, args);
		System.out.println("ForRestUrl: http://localhost:8080/api/1");
		System.out.println("SpringBootSimpleWebApplication Run Successfully Done !");
	}
}
