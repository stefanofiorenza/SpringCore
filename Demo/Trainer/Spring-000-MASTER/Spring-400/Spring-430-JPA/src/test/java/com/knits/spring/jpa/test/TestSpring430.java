package com.knits.spring.jpa.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.knits.spring.jpa.config.AppConfig;
import com.knits.spring.jpa.dao.CdDao;
import com.knits.spring.jpa.model.CD;

public class TestSpring430 {

	
	@Test
	public void testBmt() {		
		demoDaoImplByName("cdDaoJpaBMT");
	}
	
	
	@Test
	public void testCmt() {
		demoDaoImplByName("cdDaoJpaCMT");
	}
	
	
	
	private static void demoDaoImplByName(String daoBeanImpl){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CdDao cdDao= context.getBean(daoBeanImpl,CdDao.class);
		CD cd= cdDao.findById(1l);		
		System.out.println("Found "+cd.toString());
	}
}
