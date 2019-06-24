package com.knits.spring.common.service;

import java.util.List;

import com.knits.spring.common.beans.UserDto;

public interface UserService {

	Long save(UserDto user);
	
	List<UserDto> findUsersByCity(String city);
	
	void updateUser (UserDto user);
}
