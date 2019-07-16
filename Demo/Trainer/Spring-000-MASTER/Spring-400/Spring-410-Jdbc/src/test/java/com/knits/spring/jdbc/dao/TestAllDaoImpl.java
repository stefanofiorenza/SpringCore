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
	
		
	private void demoDaoImplByName(String daoBeanImpl){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CdDao cdDao= context.getBean(daoBeanImpl,CdDao.class);
				
		CD newCd =mockCd();
		Long cdId =cdDao.save(newCd);
		CD cd= cdDao.findById(cdId);		
	
	}
	
	private CD mockCd() {
		CD mock = new CD();		
		mock.setTitle("A Mock Title");
		mock.setArtist("A MOck Artist");
		mock.setCompany("A Mock Company");
		mock.setCountry("Italy");
		mock.setPrice(20.90);
		mock.setQuantity(12);
		mock.setYear(2009);
		return mock;
	}
}
