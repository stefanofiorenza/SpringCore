package com.knits.spring.common;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.knits.spring.common.beans.UserDto;
import com.knits.spring.common.dao.UserDao;
import com.knits.spring.common.integration.UserJmsClient;
import com.knits.spring.common.integration.UserRestClient;
import com.knits.spring.common.model.User;
import com.knits.spring.common.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-beans.xml"})
public class Test04CommonAppMockito {

	@Mock
	private UserJmsClient jmsClient;
	
	@Mock
	private UserRestClient userRestClient;
	
	@Mock
	private UserDao userDao;

	
	@InjectMocks	//inject (already created) mocks in autowired field of real class
	@Autowired
	private UserService userService;
	
	@Captor
	private ArgumentCaptor<User> userArgCaptor;
	
	 @Before
	 public void setUp() {
	   MockitoAnnotations.initMocks(this); //already using SpringJUnit4ClassRunner, need to create mocks
	 }
	
	 
	 @Test
	 public void testDependencies(){
		 Assert.assertNotNull(userService);
		 Assert.assertNotNull(userDao);
		 Assert.assertNotNull(userRestClient);
		 Assert.assertNotNull(jmsClient);
	 }
	
	
	 @Test
	 public void testUserInTallinn(){
		 UserDto userMock =mock(UserDto.class);
		 when(userMock.getName()).thenReturn("Stefano Fiorenza");
		 when(userMock.getCity()).thenReturn("Tallinn");
		 
		 userService.save(userMock);
		 
		 //check mock calls
		 verify(jmsClient, times(1)).sendUserToJmsQueue(userMock);
		 verify(userRestClient, times(1)).sendUserToExternalRestService(userMock);
		 verify(userDao, times(1)).persist(userArgCaptor.capture());
		 
		 Assert.assertEquals("Stefano", userArgCaptor.getValue().getFirstName());
		 Assert.assertEquals("Fiorenza", userArgCaptor.getValue().getLastName());
		 Assert.assertEquals("Tallinn", userArgCaptor.getValue().getCity());
	 }
	 
	 
	 @Test
	 public void testUser_NotInTallinn(){
		 
		 //given..
		 UserDto userMock =mock(UserDto.class);
		 when(userMock.getName()).thenReturn("Stefano Fiorenza");
		 when(userMock.getCity()).thenReturn("Rio De Janeiro");
		 
		 //when...
		 userService.save(userMock);
		 
		 //then...
		 verify(jmsClient, never()).sendUserToJmsQueue(userMock);
		 verify(userRestClient, times(1)).sendUserToExternalRestService(userMock);
		 verify(userDao, times(1)).persist(userArgCaptor.capture());
		 
		 Assert.assertEquals("Stefano", userArgCaptor.getValue().getFirstName());
		 Assert.assertEquals("Fiorenza", userArgCaptor.getValue().getLastName());
		 Assert.assertEquals("Rio De Janeiro", userArgCaptor.getValue().getCity());
	 }
	 
	 
}
