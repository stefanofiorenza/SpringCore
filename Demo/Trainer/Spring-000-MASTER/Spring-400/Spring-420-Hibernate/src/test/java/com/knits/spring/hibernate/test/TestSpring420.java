package com.knits.spring.hibernate.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.knits.spring.hibernate.config.AppConfig;
import com.knits.spring.hibernate.dao.CdDao;
import com.knits.spring.hibernate.model.CD;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestSpring420 {

	
	@Test
	public void testBmt() {		
		testCrudOperations("cdDaoHibernateBMT");		
	}
	
	
	@Test
	public void testCmt() {
		testCrudOperations("cdDaoHibernateCMT");
	}
	
	
	private void testCrudOperations(String daoBeanImpl){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		CdDao cdDao= context.getBean(daoBeanImpl,CdDao.class);
		
		List<CD> cdsToCleanFromOtherTests=cdDao.findByTitle("An Updated Mock Title");
		cdsToCleanFromOtherTests.forEach(cd ->cdDao.delete(cd));
			
		CD mockCd=mockCd();
		Long newMockCd =cdDao.save(mockCd);
		CD newInsertedCd= cdDao.findById(newMockCd);	
		Assert.assertNotNull(newInsertedCd);
		
		newInsertedCd.setTitle("An Updated Mock Title");
		cdDao.update(newInsertedCd);
		
		List<CD> foundCdsByTitle=cdDao.findByTitle("An Updated Mock Title");
		Assert.assertNotNull(foundCdsByTitle);
		Assert.assertTrue(foundCdsByTitle.size()==1);
		assertEqualsCD(newInsertedCd,foundCdsByTitle.get(0));
		
		cdDao.delete(newInsertedCd);
		CD deleted= cdDao.findById(newMockCd);	
		Assert.assertNull(deleted);
	}
	
	
	private CD mockCd() {
		CD mock = new CD();
		mock.setVersion(0L);
		mock.setTitle("A Mock Title");
		mock.setArtist("A MOck Artist");
		mock.setCompany("A Mock Company");
		mock.setCountry("Italy");
		mock.setPrice(20.90);
		mock.setQuantity(12);
		mock.setYear(2009);
		return mock;
	}
	
	private void assertEqualsCD(CD expected, CD actual) {
		
		final double tolerance=0.1;
		Assert.assertEquals(expected.getTitle(), actual.getTitle());
		Assert.assertEquals(expected.getArtist(), actual.getArtist());
		Assert.assertEquals(expected.getCompany(), actual.getCompany());
		Assert.assertEquals(expected.getCountry(), actual.getCountry());
		Assert.assertEquals(tolerance,expected.getPrice(), actual.getPrice());
		Assert.assertEquals(expected.getQuantity(), actual.getQuantity());
		Assert.assertEquals(expected.getYear(), actual.getYear());
	}
}
