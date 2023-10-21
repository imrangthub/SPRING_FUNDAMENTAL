package com.imranmadbar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching   
@SpringBootApplication
public class SpringCachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCachingApplication.class, args);

//		ApplicationContext context = new AnnotationConfigApplicationContext(CacheConfig.class);
//		CacheManager cacheManager = context.getBean(CacheManager.class);
//		String cachingProviderName = cacheManager.getClass().getCanonicalName();
//		System.out.println("Caching Provider: " + cachingProviderName);
		
		System.out.println("Simple  Application Run Successfully Done !");
	}

}