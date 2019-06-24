package com.knits.spring.common.integration;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import com.knits.spring.common.beans.UserDto;

@Slf4j
@Component
public class UserJmsClient {

	public void sendUserToJmsQueue(UserDto user){
		log.info("Send to Jms Queue");
	}
}
