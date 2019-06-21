package com.knits.spring.jdbc.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.knits.spring.common.model.CD;
import com.knits.spring.jdbc.config.AppConfig;
import com.knits.spring.jdbc.dao.CdDao;


public class DemoCrudCd {

	public static void main(String[] args) {
		
		
		demoDaoImplByName("cdDaoJdbcSupportImpl");
		demoDaoImplByName("cdDaoJdbcTemplate");
		demoDaoImplByName("cdDaoNamedParametersJdbcTemplate");
		
	}
	
	
	private static void demoDaoImplByName(String daoBeanImpl){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CdDao cdDao= context.getBean(daoBeanImpl,CdDao.class);
		CD cd= cdDao.findById(1l);		
		System.out.println("Found "+cd.toString());
	}

}
