package com.knits.spring.hibernate.config;

import java.util.Properties;

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
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.knits.spring.hibernate.dao")
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class AppConfig {

	private final String URL = "url";
	private final String USER = "dbuser";
	private final String DRIVER = "driver";
	private final String PASSWORD = "dbpassword";
	private final String HIBERNATE_DIALECT = "dialect";
	private final String HIBERNATE_DDL = "hibernate.ddl";
	private final String HIBERNATE_SHOW_SQL = "hibernate.showsql";

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
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setPackagesToScan("com.knits.spring.hibernate.model");
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties()); 
        return sessionFactory;
    }
	
	@Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
 
    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(org.hibernate.cfg.Environment.DIALECT, env.getProperty(HIBERNATE_DIALECT));
        hibernateProperties.setProperty(org.hibernate.cfg.Environment.HBM2DDL_AUTO,env.getProperty(HIBERNATE_DDL));//"hibernate.hbm2ddl.auto"
        hibernateProperties.setProperty(org.hibernate.cfg.Environment.SHOW_SQL,env.getProperty(HIBERNATE_SHOW_SQL));
        hibernateProperties.setProperty(org.hibernate.cfg.Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread"); // necessary for BMT .currentSession()
        return hibernateProperties;
    }

    
    
}
