//package com.imranmadbar;
//
//import java.time.Duration;
//
//import org.springframework.cloud.gateway.config.HttpClientProperties;
//import org.springframework.cloud.gateway.config.HttpClientProperties.Pool.PoolType;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//@Configuration
//public class AppConfig {
//
//	@Bean
//	@Primary
//	public HttpClientProperties overwrittenHttpClientProperties() {
//		HttpClientProperties p = new HttpClientProperties();
//		p.setConnectTimeout(10000);
//		p.setResponseTimeout(Duration.ofMillis(25000));
//		p.getPool().setMaxConnections(5000);
//		p.getPool().setType(PoolType.FIXED);
//		p.getPool().setMaxIdleTime(Duration.ofMillis(100));
//		p.getPool().setMaxLifeTime(Duration.ofMillis(20000));
//		p.getPool().setMetrics(true);
//
//		return p;
//	}
//	
//	
//	
//
//}
