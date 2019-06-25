package com.knits.spring.common.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import com.knits.spring.common.model.User;

@Slf4j
@Repository
public class UserDaoImpl implements UserDao {

	@Getter
	@Setter
	private String dbUsername;
	
	@Getter
	@Setter
	private String dbPassword;
	
	
	@Override
	public Long persist(User user) {	
		log.info("User {} Saved in DB ", user.toString());
		return 1L;
	}

	@Override
	public List<User> searchUsersByCity(String city) {	
		log.info("Search By City {} . Will return empty resultset", city);
		return new ArrayList<User>();
	}

	@Override
	public void merge(User user) {
		log.info("User {} updated in DB ", user.toString());
	}

}
