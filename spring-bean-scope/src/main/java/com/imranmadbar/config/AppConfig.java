package com.imranmadbar.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.imranmadbar.employee.EmployeeEntity;

@Configuration
public class AppConfig {

	@Bean("employeeObj")
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public EmployeeEntity getAccountService() {
		return new EmployeeEntity();
	}

}
