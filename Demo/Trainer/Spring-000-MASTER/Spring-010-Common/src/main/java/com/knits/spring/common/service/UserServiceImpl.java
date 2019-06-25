package com.knits.spring.common.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import com.knits.spring.common.beans.UserDto;
import com.knits.spring.common.dao.UserDao;
import com.knits.spring.common.integration.UserJmsClient;
import com.knits.spring.common.integration.UserRestClient;
import com.knits.spring.common.model.User;
import com.knits.spring.common.utils.BeanUtils;

@Slf4j
@Data
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserJmsClient jmsClient;
	
	@Autowired
	private UserRestClient userRestClient;
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public Long save(UserDto user) {

		log.info("Saving User {} ...",user.toString());
		
		if(user.getCity().equals("Tallinn")){
			jmsClient.sendUserToJmsQueue(user);
			log.info("User {} Sent To JmsQueue ",user.toString());
		}
		
		userRestClient.sendUserToExternalRestService(user);
		log.info("User {} Sent To ExternalRestService ",user.toString());
		
		User userEntity = BeanUtils.dto2Model(user);
		Long newUserId = userDao.persist(userEntity);
		log.info("User {} Saved into DB ",user.toString());
		return newUserId;
	}

	@Override
	public List<UserDto> findUsersByCity(String city) {
		log.info("Search Users by City {} ",city);
		List<User> usersFromDd =userDao.searchUsersByCity(city);		
		List<UserDto> usersAsDtos =new ArrayList<UserDto>();
		usersFromDd.forEach(user -> usersAsDtos.add(BeanUtils.model2Dto(user)));
		return usersAsDtos;
	}

	@Override
	public void updateUser(UserDto user) {
		log.info("Update User {} ",user.toString());
		
		userRestClient.sendUserToExternalRestService(user);
		log.info("User {} Sent To ExternalRestService ",user.toString());
		
		User userEntity = BeanUtils.dto2Model(user);
		userDao.merge(userEntity);
		log.info("User {} Updated into DB ",user.toString());
		
	}

}
