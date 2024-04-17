package com.imranmadbar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SoapServiceProducerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SoapServiceProducerApplication.class, args);
		System.out.println("SoapServiceProducerApplication Run Successfully Done !");
	}

}
