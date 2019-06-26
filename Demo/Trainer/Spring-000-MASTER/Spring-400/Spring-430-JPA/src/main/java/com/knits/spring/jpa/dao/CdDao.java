package com.knits.spring.jpa.dao;

import java.util.List;

import com.knits.spring.jpa.model.CD;

public interface CdDao {


	public com.knits.spring.jpa.model.CD findById (Long id);
	
	public List<CD> findByTitle (String title);
	
	public Long save (CD newCd);
	
	public void update (CD updatedCd);
	
	public void delete (CD updatedCd);
	
}
