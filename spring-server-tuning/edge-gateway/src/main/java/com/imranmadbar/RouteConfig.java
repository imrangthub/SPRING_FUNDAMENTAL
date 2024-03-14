package com.imranmadbar;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return (RouteLocator) builder.routes()
				.route("users", t -> t.path("/**").uri("http://localhost:9191/")
						)

				.build();
	}

}
