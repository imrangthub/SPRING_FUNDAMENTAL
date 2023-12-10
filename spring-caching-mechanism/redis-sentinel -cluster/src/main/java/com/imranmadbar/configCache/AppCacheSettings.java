package com.imranmadbar.configCache;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "api-mapping")
public class AppCacheSettings {

	private Map<String, String> appCacheMap;

	public Map<String, String> getAppCacheMap() {
		return appCacheMap;
	}

	public void setAppCacheMap(Map<String, String> appCacheMap) {
		this.appCacheMap = appCacheMap;
	}
}