package com.imranmadbar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.imranmadbar")
@SpringBootApplication
public class BusinessSvcWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessSvcWebApplication.class, args);
		System.out.println("BusinessSvcWebApplication Run Successfully Done !");
	}
}
