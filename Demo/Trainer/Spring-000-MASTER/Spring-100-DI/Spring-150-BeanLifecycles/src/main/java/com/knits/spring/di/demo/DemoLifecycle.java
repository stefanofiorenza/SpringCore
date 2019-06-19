package com.knits.spring.di.demo;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.knits.spring.common.service.ServiceMessage;
import com.knits.spring.common.service.ServiceWithCollections;
import com.knits.spring.common.service.UserService;
import com.knits.spring.common.utils.Mocks;

@Slf4j
public class DemoLifecycle {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		ServiceMessage serviceMessage = context.getBean(ServiceMessage.class);
		serviceMessage.logMessage("A message to Log");		
		
		//beans are cleaned up from context..
		context.close();
	}
	
	


}
