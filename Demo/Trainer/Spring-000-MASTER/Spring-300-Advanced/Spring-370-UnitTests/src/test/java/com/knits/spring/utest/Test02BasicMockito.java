package com.knits.spring.utest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class Test02BasicMockito {

	@Test
	public void testStubbing(){
				
		@SuppressWarnings( "unchecked" )
		List<String> aMockedListOfString= Mockito.mock(ArrayList.class);
		
		@SuppressWarnings( "unchecked" )
		List<String> aListWhatIsNeverCalled= Mockito.mock(ArrayList.class);
		
		
		//setup mock behavior
		Mockito.when(aMockedListOfString.indexOf("A Test")).thenReturn(-1);
		
		//real call on the mock
		aMockedListOfString.indexOf("A Test");
		
		
		//1) verify that method was called
		Mockito.verify(aMockedListOfString).indexOf("A Test");
		
		//2) verify that method was called (times)
		Mockito.verify(aMockedListOfString, Mockito.times(1)).indexOf("A Test");
		
		//3) verify no interaction with method
		Mockito.verifyZeroInteractions(aListWhatIsNeverCalled);
		
		
		//Other calls
		aMockedListOfString.size();
		aMockedListOfString.add("A Test");
		aMockedListOfString.remove(0);
		aMockedListOfString.clear();
		
		//4) Verify order of calls
		InOrder inOrder = Mockito.inOrder(aMockedListOfString);
		inOrder.verify(aMockedListOfString).indexOf("A Test");
		inOrder.verify(aMockedListOfString).size();
		inOrder.verify(aMockedListOfString).add("A Test");
		inOrder.verify(aMockedListOfString).remove(0);
		inOrder.verify(aMockedListOfString).clear();
		
		//5) zero calls
		Mockito.verify(aMockedListOfString, Mockito.never()).contains("A Test"); 
		
	}
	

	
}
