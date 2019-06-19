package com.knits.spring.di.demo;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.knits.spring.common.dao.UserDao;
import com.knits.spring.common.dao.UserDaoImpl;
import com.knits.spring.common.service.ServiceWithCollections;
import com.knits.spring.common.service.UserService;
import com.knits.spring.common.utils.Mocks;

@Slf4j
public class DemoBeanScopes {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		UserDaoImpl userDao1= context.getBean(UserDaoImpl.class);
		UserDaoImpl userDao2= context.getBean(UserDaoImpl.class);		
				
		log.info("Current state userDao1 Username: {} Password: {}",userDao1.getDbUsername(),userDao1.getDbPassword() );		
		userDao2.setDbPassword("newPasswordFromUserDao2");
		
		log.info("Current state userDao1 Username: {} Password: {}",userDao1.getDbUsername(),userDao1.getDbPassword() );		
		
	}


	
}
