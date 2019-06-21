package com.knits.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.knits.spring.common.model.CD;
import com.knits.spring.jdbc.dao.helpers.CdRowMapper;

public interface CdDao {


	public CD findById (Long id);
	
	public List<CD> findByTitle (String title);
	
	public Long save (CD newCd);
	
	public void update (CD updatedCd);
	
	public void delete (CD updatedCd);
	
}
