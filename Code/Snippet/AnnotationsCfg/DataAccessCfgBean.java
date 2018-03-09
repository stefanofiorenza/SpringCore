package com.sportradar.lms.config.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class DataAccessCfgBean {

	private String url;
	private String username;
	private String password;
	private String driverClassName;
	
	public DataAccessCfgBean(
			@Value("#{datasource.url}")String url, 
			@Value("#{datasource.username}")String username, 
			@Value("#{datasource.password}")String password,
			@Value("#{datasource.driverClassName}")String driverClassName) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
		this.driverClassName = driverClassName;
	}


	 
}
