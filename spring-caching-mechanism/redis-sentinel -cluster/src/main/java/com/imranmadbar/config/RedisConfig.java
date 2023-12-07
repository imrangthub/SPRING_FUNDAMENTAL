//package com.imranmadbar.config;
//
//import java.time.Duration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//
//@Configuration
//public class RedisConfig {
//
//	@Bean
//	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
//		RedisTemplate<String, Object> template = new RedisTemplate<>();
//		template.setConnectionFactory(connectionFactory);
//		return template;
//	}
//
//	@Bean
//	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//		// Cache for get-customer with 24-hour expiration
//		RedisCacheConfiguration customerCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
//				.entryTtl(Duration.ofHours(24)).disableCachingNullValues();
//
//		// Cache for get-customer-list with 5-minute expiration
//		RedisCacheConfiguration customerListCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
//				.entryTtl(Duration.ofMinutes(5)).disableCachingNullValues();
//
//		return RedisCacheManager.builder(connectionFactory)
//				.withCacheConfiguration("get-customer", customerCacheConfig)
//				.withCacheConfiguration("get-customer-list", customerListCacheConfig).build();
//	}
//}