package com.knits.spring.jdbc.dao;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.knits.spring.common.model.CD;
import com.knits.spring.jdbc.config.AppConfig;

public class TestAllDaoImpl {

	
	@Test
	public void datasourceShouldBeConfigured() throws SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		DataSource datasource =context.getBean(DataSource.class);
		
		assertNotNull(datasource);
		assertNotNull(datasource.getConnection());
	}
	
	
	@Test
	public void testCdDaoJdbcSupportImpl() {
		demoDaoImplByName("cdDaoJdbcSupportImpl");
	}
	
	@Test
	public void testCdDaoJdbcTemplate() {
		demoDaoImplByName("cdDaoJdbcTemplate");
	}
	
	@Test
	public void testCdDaoNamedParametersJdbcTemplate() {
		demoDaoImplByName("cdDaoNamedParametersJdbcTemplate");
	}
	
		
	private static void demoDaoImplByName(String daoBeanImpl){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CdDao cdDao= context.getBean(daoBeanImpl,CdDao.class);
		CD cd= cdDao.findById(1l);		
		System.out.println("Found "+cd.toString());
	}
}
