//package com.imranmadbar.config;
//
//import java.time.Duration;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//
//@Configuration
//public class RedisConfig2 {
//
//	@Bean
//	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
//
//		RedisTemplate<String, Object> template = new RedisTemplate<>();
//		template.setConnectionFactory(connectionFactory);
//		
//        // Set serializers for keys and values
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        
//        // Set hash key and value serializers
//        template.setHashKeySerializer(new StringRedisSerializer());
//        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
//        
//		return template;
//	}
//
//	
//	@Bean
//	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//		// Cache for get-customer with 24-hour expiration
//		RedisCacheConfiguration customerCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
//				.entryTtl(Duration.ofHours(24));
//
//		// Cache for get-customer-list with 5-minute expiration
//		RedisCacheConfiguration customerListCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
//				.entryTtl(Duration.ofMinutes(5));
//
//		return RedisCacheManager.builder(connectionFactory)
//				.withCacheConfiguration("get-customer", customerCacheConfig)
//				.withCacheConfiguration("get-customer-list", customerListCacheConfig).build();
//	}
//	
//	
//	
//	
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
