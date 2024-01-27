package com.imranmadbar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringBootSimpleWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSimpleWebApplication.class, args);

        
		System.out.println("SpringBootSimpleWebApplication Run Successfully Done !");
	}
}
