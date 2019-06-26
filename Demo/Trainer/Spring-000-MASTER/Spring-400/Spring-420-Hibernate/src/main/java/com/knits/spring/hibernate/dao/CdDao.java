package com.knits.spring.hibernate.dao;

import java.util.List;

import com.knits.spring.hibernate.model.CD;

public interface CdDao {


	public CD findById (Long id);
	
	public List<CD> findByTitle (String title);
	
	public Long save (CD newCd);
	
	public void update (CD updatedCd);
	
	public void delete (CD updatedCd);
	
}
