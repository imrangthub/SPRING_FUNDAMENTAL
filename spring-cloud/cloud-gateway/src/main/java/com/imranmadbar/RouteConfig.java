package com.imranmadbar;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
	
	
  @Bean
  public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
        	.route("mc1", r -> r.path("/one/**")
        		      .filters(f -> f.filter(new CustomFilter().apply(new CustomFilter.Config())))
        			.uri("lb://microservice-one"))
         	.route("mc2", r -> r.path("/two/**")
        		      .filters(f -> f.filter(new CustomFilter().apply(new CustomFilter.Config())))
         			.uri("lb://microservice-two"))
         	.build();
    }
  
	  
	  

//	@Bean
//	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route(r -> r
//						.path("/employee/**")
//						.filters(f -> f.addRequestHeader("my-custom-header-request", "first-request-header")
//								.addResponseHeader("my-custom-header-response", "first-response-header"))
//						.uri("http://localhost:8081/"))
//
//				.route(r -> r.path("/consumer/**")
//						.filters(f -> f.addRequestHeader("second-request", "second-request-header")
//								.addResponseHeader("second-response", "second-response-header"))
//						.uri("http://localhost:8082/"))
//				.build();
//	}

}