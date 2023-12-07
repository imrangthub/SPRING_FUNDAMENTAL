package com.imranmadbar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching   
@SpringBootApplication
public class RedisSentinelClusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisSentinelClusterApplication.class, args);
		System.out.println("RedisSentinelClusterApplication Run Successfully Done !");
	}

}