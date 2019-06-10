package com.knits.spring.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.knits.spring.common.dao.UserDao;
import com.knits.spring.common.dao.UserDaoImpl;
import com.knits.spring.common.service.ServiceWithCollections;

@Configuration
@ComponentScan({ "com.knits.spring.common.integration", "com.knits.spring.common.service" })
public class AppConfig {

	@Bean
	public ServiceWithCollections serviceWithCollections(){
		ServiceWithCollections bean = new ServiceWithCollections();
		
		bean.getTechnologySkillsList().add("Hibernate");
		bean.getTechnologySkillsList().add("Java");
		bean.getTechnologySkillsList().add("Spring");
				
		bean.getTechnologySkillsSet().add("Hibernate");
		bean.getTechnologySkillsSet().add("Java");
		bean.getTechnologySkillsSet().add("Spring");
		
		bean.getTechnologySkillsMap().put("Hibernate","7");
		bean.getTechnologySkillsMap().put("Java","7");
		bean.getTechnologySkillsMap().put("Spring","6");
		
		return bean;
	}
	
		
	@Bean
	public UserDao userDao(){
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.setDbUsername("SomeUsername");
		userDao.setDbPassword("SomeSafePw");
		return userDao;
		
	}
}
