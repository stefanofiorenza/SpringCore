package com.knits.spring.common.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceMessage implements InitializingBean, DisposableBean{

	
	public void logMessage(String message){
		log.info(message);
	}
	
	
	@PostConstruct
	public void anInitializingMethod(){
		log.info("[PostConstruct] ServiceMessage was just added to Spring Context.");		
	}
	
	@PreDestroy
	public void beforeDestroy(){
		log.info("[beforeDestroy] ServiceMessage is cleaned up from Spring Context.");	
	}
	
	
	//@Override
	public void afterPropertiesSet() throws Exception {
		log.info("[afterPropertiesSet] ServiceMessage was just added to Spring Context.");		
	}
	
	
	//@Override
	public void destroy() throws Exception {
		log.info("[destroy] ServiceMessage is cleaned up from Spring Context.");
	}

	
	public void anotherInitializingMethod(){
		log.info("[fromXmlConfiguration] ServiceMessage was just added to Spring Context.");
	}
	
	
	public void anotherBeforeDestroy(){
		log.info("[anotherBeforeDestroy] ServiceMessage is cleaned up from Spring Context.");	
	}
}
