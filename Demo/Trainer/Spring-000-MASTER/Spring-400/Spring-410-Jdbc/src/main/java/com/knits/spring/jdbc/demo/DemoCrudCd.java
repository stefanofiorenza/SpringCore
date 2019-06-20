package com.knits.spring.jdbc.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.knits.spring.jdbc.config.AppConfig;
import com.knits.spring.jdbc.dao.CdDao;


public class DemoCrudCd {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CdDao cdDao= context.getBean(CdDao.class);		
	}

}
