package com.sportradar.lms.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import com.sportradar.lms.config.beans.DataAccessCfgBean;

@Configuration
public class DataAccessConfig {

	private DataAccessCfgBean dataCfg;
	
	@Bean
	public DataSource lmsDatasource(){		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(dataCfg.getUrl());
		dataSource.setUsername(dataCfg.getUsername());
		dataSource.setPassword(dataCfg.getPassword());
		dataSource.setDriverClassName(dataCfg.getDriverClassName());
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager sbatchTransactionManager(){
		return new DataSourceTransactionManager(lmsDatasource());
	}
}
