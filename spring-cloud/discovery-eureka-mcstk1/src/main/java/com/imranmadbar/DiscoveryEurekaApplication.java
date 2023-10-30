package com.imranmadbar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryEurekaApplication {

  public static void main(String[] args) {
    SpringApplication.run(DiscoveryEurekaApplication.class, args);
	System.out.println("DiscoveryEurekaApplication Run Successfully Done !");
  }

}

