package com.knits.spring.di.demo;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.knits.spring.common.service.ServiceWithCollections;
import com.knits.spring.common.service.UserService;
import com.knits.spring.common.utils.Mocks;

@Slf4j
public class DemoClasspathScanning {

	public static void main(String[] args) {
		//demo01_saveUser();

		demo02_collectionInjection();
	}

	private static void demo01_saveUser(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		context.getBean(UserService.class).save(Mocks.mockUser());
	}
	
	
	private static void demo02_collectionInjection(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		ServiceWithCollections service=context.getBean(ServiceWithCollections.class);
		log.info("List: {} ",service.getTechnologySkillsList().toString());
		log.info("Set: {} ",service.getTechnologySkillsSet().toString());
		log.info("Map: {} ",service.getTechnologySkillsMap().toString());
	}
}
