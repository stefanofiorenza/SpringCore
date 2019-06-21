package com.knits.spring.jdbc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.knits.spring.jdbc.dao.CdDao;
import com.knits.spring.jdbc.dao.CdDaoJdbcSupportImpl;
import com.knits.spring.jdbc.dao.CdDaoJdbcTemplate;
import com.knits.spring.jdbc.dao.helpers.CdRowMapper;

@Configuration
@ComponentScan("com.knits.spring.jdbc.dao")
@PropertySource("classpath:database.properties")
public class AppConfig {

	private final String URL = "url";
	private final String USER = "dbuser";
	private final String DRIVER = "driver";
	private final String PASSWORD = "dbpassword";
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(env.getProperty(URL));
		driverManagerDataSource.setUsername(env.getProperty(USER));
		driverManagerDataSource.setPassword(env.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(env.getProperty(DRIVER));
		return driverManagerDataSource;
	}
	
	
	@Bean
	public CdRowMapper cdRowMapper(){
		return new CdRowMapper();
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource datasource){
		return new JdbcTemplate(datasource);
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource datasource){
		return new NamedParameterJdbcTemplate(datasource);
	}
	
	
	
	
}
