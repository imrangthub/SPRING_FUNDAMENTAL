package com.imranmadbar.configCache;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cache-config")
public class CacheSettings {

	private List<CacheSettingsModel> defaultConfigs;

	public List<CacheSettingsModel> getDefaultConfigs() {
		return defaultConfigs;
	}

	public void setDefaultConfigs(List<CacheSettingsModel> configList) {
		this.defaultConfigs = configList;
	}

	public Map<String, CacheSettingsModel> getCacheConfigAsMap() {
		if (defaultConfigs == null) {
			return Collections.emptyMap();
		}
		return defaultConfigs.stream().collect(Collectors.toMap(CacheSettingsModel::getCacheName, c -> c));
	}

}