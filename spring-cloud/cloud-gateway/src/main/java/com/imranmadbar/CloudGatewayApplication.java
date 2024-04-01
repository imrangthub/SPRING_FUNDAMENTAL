package com.imranmadbar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudGatewayApplication {

	/*
	 * @Bean public RouteLocator myRoutes(RouteLocatorBuilder builder) { return
	 * builder.routes() .route(p -> p.path("/one/**") .filters(f ->
	 * f.rewritePath("/one/(?<segment>.*)", "/${segment}")
	 * .addResponseHeader("X-Response-Time", new Date().toString()))
	 * .uri("lb://microservice-one")) .route(p -> p.path("/microservice-one/one/**")
	 * .filters(f -> f.rewritePath("/microservice-one/one/(?<segment>.*)",
	 * "/${segment}") .addResponseHeader("X-Response-Time", new Date().toString()))
	 * .uri("lb://microservice-one")) .build(); }
	 */

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
		System.out.println("CloudGatewayApplication Run Successfully Done !");
	}

}