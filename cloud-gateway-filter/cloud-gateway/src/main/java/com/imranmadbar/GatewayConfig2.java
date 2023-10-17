package com.imranmadbar;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class GatewayConfig2 {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route( route -> route
                		.path("/employee/**")
                              .filters(f -> f.filter(new CustomFilter().apply(new CustomFilter.Config())))
                        .uri("http://localhost:8081")
                )

                .build();
    }
}
