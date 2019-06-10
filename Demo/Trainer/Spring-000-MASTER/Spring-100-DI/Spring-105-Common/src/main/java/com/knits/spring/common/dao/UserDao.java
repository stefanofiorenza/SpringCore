package com.knits.spring.common.dao;

import java.util.List;

import com.knits.spring.common.model.User;

public interface UserDao {

	Long persist(User user);
	
	List<User> searchUsersByCity(String city);
	
	void merge (User user);
}
