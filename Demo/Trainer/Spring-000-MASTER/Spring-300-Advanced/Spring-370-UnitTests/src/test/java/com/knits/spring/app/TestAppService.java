package com.knits.spring.app;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestAppService {

		
	AppService appService;

	
	
	@Before
	public void initAppServiceTest(){
		
		@SuppressWarnings( "unchecked" )
		List<String> mockRepository= Mockito.mock(ArrayList.class);
		
		appService= new AppService();
		appService.setRepository(mockRepository);
	}
	
	@Test
	public void shouldFilterStringNotStartingFromS(){
		
		int numberOfInteraction= 7;
		int numberOfStringToAdd= 3;
		int numberOfStringToFilter= 5;
		
		//setup behavior
		Mockito.when(appService.getRepository().size()).thenReturn(numberOfInteraction);
		
		// add 3 string
		for (int i=0; i<numberOfStringToAdd; i++){
			Mockito.when(appService.getRepository().get(i)).thenReturn("S this should be included");
		}
		
		// add 4 strings to be filtered out
		for (int i=numberOfStringToAdd; i<numberOfInteraction; i++){
			Mockito.when(appService.getRepository().get(i)).thenReturn("AString What should be not Included");
		}
		
		
		// method to test
		List<String> result = appService.listAll();
		
		
		
		//assertions
		Assert.assertEquals(3, result.size());
		Assert.assertTrue("S this should be included".equals(result.get(0)));
		Assert.assertTrue("S this should be included".equals(result.get(1)));
		Assert.assertTrue("S this should be included".equals(result.get(2)));
	
		//verify calls on mock
		Mockito.verify(appService.getRepository(),Mockito.times(8)).size(); // 7 loops and one on exit
		
		for (int i=0; i<numberOfInteraction; i++){
			Mockito.verify(appService.getRepository(),Mockito.times(1)).get(i);
		}
		
	}
	
	@Test
	public void shouldAddString_StartingWithS(){
		appService.add("Stefano");
		Mockito.verify(appService.getRepository(),Mockito.times(1)).add("Stefano");
	}
	
	
	@Test
	public void shouldNotAddString_NotStartingWithS(){
		appService.add("AnotherString");
		Mockito.verify(appService.getRepository(),Mockito.never()).add("AnotherString");
	}
	
	@Test
	public void shouldReturnDefaultForFindByPositionLowerThanZero(){
		appService.findByPosition(-1);
		Mockito.verify(appService.getRepository(),Mockito.times(0)).get(-1);
	}
	
	
	
	
}
