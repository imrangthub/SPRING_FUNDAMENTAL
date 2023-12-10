package com.imranmadbar.configCache;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class CacheConfig {

	@Autowired
	private CacheSettings cacheSettings;

	@Autowired
	private AppCacheSettings appCacheSettings;

	@Autowired
	private RedisProperties redisProperties;
	
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		return template;
	}

	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
				.master(redisProperties.getSentinel().getMaster());
		redisProperties.getSentinel().getNodes()
				.forEach(s -> sentinelConfig.sentinel(s, Integer.valueOf(redisProperties.getPort())));
		sentinelConfig.setPassword(RedisPassword.of(redisProperties.getPassword()));
		return new LettuceConnectionFactory(sentinelConfig);
	}

	@Bean
	public RedisCacheConfiguration cacheConfiguration() {
		return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(600));
	}


	@Bean
	public RedisCacheManager cacheManager() {
		Map<String, RedisCacheConfiguration> cacheConfigs = new HashMap<>();
		Map<String, CacheSettingsModel> cacheConfigMap = cacheSettings.getCacheConfigAsMap();
		Map<String, String> appCacheMap = appCacheSettings.getAppCacheMap();
		appCacheMap.forEach((key, value) -> cacheConfigs.put(key, buildRedisCacheConfig(cacheConfigMap.get(value))));
		return RedisCacheManager.builder(redisConnectionFactory()).cacheDefaults(cacheConfiguration())
				.withInitialCacheConfigurations(cacheConfigs).transactionAware().build();
	}
	
	private RedisCacheConfiguration buildRedisCacheConfig(CacheSettingsModel cachesProperties) {
		return RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofSeconds(Long.parseLong(cachesProperties.getTimeToLiveSeconds())));
	}
}
