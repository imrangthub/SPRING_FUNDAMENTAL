//package com.imran.moduleservicetwo;
//
//import javax.sql.DataSource;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@ConfigurationProperties("spring.datasource")
//public class AppDBConfiguration {
//
//	private String driverClassName;
//	private String url;
//	private String username;
//	private String password;
//
//	@Bean
//	public DataSource devDataSource() {
//		return createDataSource();
//	}
//
//	private DataSource createDataSource() {
//		return DataSourceBuilder.create()
//				.username(username)
//				.password(password)
//				.url(url)
//				.driverClassName(driverClassName)
//				.build();
//	}
//
//}
