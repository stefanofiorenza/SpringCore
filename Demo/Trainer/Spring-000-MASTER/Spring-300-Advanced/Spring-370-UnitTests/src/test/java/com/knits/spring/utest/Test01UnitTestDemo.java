package com.knits.spring.utest;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


@Slf4j
public class Test01UnitTestDemo {

	@Test
	public void testArrayList(){
		log.info("[testArrayList]");
		List<String> list = new ArrayList<String>();
		Assert.assertEquals("Array list should be empty here", 0,list.size());
		
		list.add("String 1");
		list.add("String 2");
		list.add("String 3");
		
		Assert.assertEquals("After insert array should have 3 elements. add Was failing", 3,list.size());
		Assert.assertTrue(list.get(0).equals("String 1"));
		
		
		list.remove(0);
		Assert.assertEquals(2,list.size()); //check default message		
		Assert.assertTrue(list.get(0).equals("String 2"));		
	}
	
	
	@Test(expected=NullPointerException.class)
	public void testException(){
		log.info("[testException]");
		List<String> list=null;
		list.add("String 1");
		Assert.fail("Expected null pointer exception");		
	}
	
	
	@Before
	public void initCurrentTest(){
		log.info("initCurrentTest Method Called");
	}
	
	@After
	public void endCurrentTest(){
		log.info("endCurrentTest Method Called");
	}
	
	
	@BeforeClass
	public static void initClass(){
		log.info("initClass Method Called");
	}
	
	@AfterClass
	public static void endClass(){
		log.info("endClass Method Called");
	}
	
}
