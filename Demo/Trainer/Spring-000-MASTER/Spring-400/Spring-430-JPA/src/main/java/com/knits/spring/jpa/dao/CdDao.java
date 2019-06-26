package com.knits.spring.jpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.knits.spring.common.model.CD;

public interface CdDao {


	public CD findById (Long id);
	
	public List<CD> findByTitle (String title);
	
	public Long save (CD newCd);
	
	public void update (CD updatedCd);
	
	public void delete (CD updatedCd);
	
}
