//package com.imranmadbar;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.RetryGatewayFilterFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//
//@Configuration
//public class GatewayConfig {
//
//	@Bean
//	public GatewayFilter customRetryGatewayFilter() {
//		// Configure the retry filter with desired settings
//		RetryGatewayFilterFactory.RetryConfig retryConfig = new RetryGatewayFilterFactory.RetryConfig();
//		retryConfig.setRetries(3);
//		retryConfig.setStatuses(HttpStatus.INTERNAL_SERVER_ERROR);
//
//		// Create and return the retry filter
//		return new RetryGatewayFilterFactory().apply(retryConfig);
//	}
//}