package com.knits.spring.utest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;


@RunWith(MockitoJUnitRunner.class) //(1) Enable annotation processing OR (2) MockitoAnnotations.initMocks
public class Test03MockitoAnnotations {

	
	@Mock //3) mock class (Mockito.mock)
	List<String> aMockedListOfString;
	
	@Mock
	List<String> aListWhatIsNeverCalled;
	
	@Before
	public void init(){
		//MockitoAnnotations.initMocks(this); //(2) programmatic initialization of mocks
	}
	
	
	@Test
	public void testStubbing(){
				
		
		//setup mock behavior
		when(aMockedListOfString.indexOf("A Test")).thenReturn(-1);
		
		//real call on the mock
		aMockedListOfString.indexOf("A Test");
		
		
		//1) verify that method was called
		verify(aMockedListOfString).indexOf("A Test");
		
		//2) verify that method was called (times)
		verify(aMockedListOfString, times(1)).indexOf("A Test");
		
		//3) verify no interaction with method
		verifyZeroInteractions(aListWhatIsNeverCalled);
		
		
		//Other calls
		aMockedListOfString.size();
		aMockedListOfString.add("A Test");
		aMockedListOfString.remove(0);
		aMockedListOfString.clear();
		
		//4) Verify order of calls
		InOrder inOrder = inOrder(aMockedListOfString);
		inOrder.verify(aMockedListOfString).indexOf("A Test");
		inOrder.verify(aMockedListOfString).size();
		inOrder.verify(aMockedListOfString).add("A Test");
		inOrder.verify(aMockedListOfString).remove(0);
		inOrder.verify(aMockedListOfString).clear();
		
		//5) zero calls
		verify(aMockedListOfString, never()).contains("A Test"); 
		
	}
}
