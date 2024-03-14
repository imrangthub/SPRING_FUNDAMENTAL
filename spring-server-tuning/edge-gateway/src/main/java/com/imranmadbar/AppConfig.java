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
//import reactor.netty.http.client.HttpClient;
//
//@Configuration
//public class AppConfig {
//
//	@Bean
//	@Primary
//	public HttpClientProperties overwrittenHttpClientProperties() {
//		HttpClientProperties p = new HttpClientProperties();
//        p.setConnectTimeout(100);
//		p.setResponseTimeout(Duration.ofMinutes(15));
//		p.getPool().setMaxConnections(500);
//		p.getPool().setType(PoolType.FIXED);
//		p.getPool().setMaxIdleTime(Duration.ofMillis(1000));
//		p.getPool().setMaxLifeTime(Duration.ofMillis(20000));
//		p.getPool().setMetrics(true);
//		
//
//		return p;
//	}
//	
////	 @Bean
////	 HttpClient create() {
////	     return HttpClient.create().responseTimeout(Duration.ofMinutes(15));
////	}
//
//}
