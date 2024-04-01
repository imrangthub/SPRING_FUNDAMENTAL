package com.imranmadbar;

import java.util.Date;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class GatewayConfiguration {
	
	@Bean
	public RedisRateLimiter redisRateLimiter() {
	    return new RedisRateLimiter(2, 20, 10);
	}
	
	@Bean
    public KeyResolver userKeyResolver() {
        return exchange -> {
            return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
        };
    }


	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/microservice-one/**")
			            .filters(f -> f.rewritePath("/microservice-one/(?<segment>.*)", "/${segment}"))
						.uri("lb://microservice-one"))
				.route(p -> p.path("/microservice-two/**")
			            .filters(f -> f
			            		.rewritePath("/microservice-two/(?<segment>.*)", "/${segment}")
			            		.requestRateLimiter(r -> r.setRateLimiter(redisRateLimiter())
			            				.setDenyEmptyKey(true)
			            				.setKeyResolver(userKeyResolver())
			            				)
			            .addResponseHeader("X-Response-Time", new Date().toString()))
						.uri("lb://microservice-two"))
				.build();
	}

}
