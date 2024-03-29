package com.imranmadbar;

import java.time.Duration;

import org.springframework.cloud.gateway.config.HttpClientProperties;
import org.springframework.cloud.gateway.config.HttpClientProperties.Pool.PoolType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

	@Bean
	@Primary
	public HttpClientProperties overwrittenHttpClientProperties() {
		HttpClientProperties p = new HttpClientProperties();
		p.setConnectTimeout(3000);
		p.setResponseTimeout(Duration.ofMillis(25000));
		p.getPool().setMaxConnections(5000);
		p.getPool().setType(PoolType.DISABLED);
//		p.getPool().setMaxIdleTime(Duration.ofMillis(160000));
		p.getPool().setMetrics(true);

		return p;
	}

}
