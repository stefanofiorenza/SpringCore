package com.knits.spring.hibernate.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.knits.spring.hibernate.config.AppConfig;
import com.knits.spring.hibernate.dao.CdDao;
import com.knits.spring.hibernate.model.CD;

public class TestSpring420 {

	
	@Test
	public void testBmt() {		
		demoDaoImplByName("cdDaoHibernateBMT");		
	}
	
	
	@Test
	public void testCmt() {
		demoDaoImplByName("cdDaoHibernateCMT");
	}
	
	
	private void demoDaoImplByName(String daoBeanImpl){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CdDao cdDao= context.getBean(daoBeanImpl,CdDao.class);
		CD cd= cdDao.findById(1l);		
		System.out.println("Found "+cd.toString());
	}
}
