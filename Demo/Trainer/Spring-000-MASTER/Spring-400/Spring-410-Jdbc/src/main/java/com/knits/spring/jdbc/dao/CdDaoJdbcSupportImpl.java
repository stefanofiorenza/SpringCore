package com.knits.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.knits.spring.common.model.CD;

public class CdDaoJdbcSupportImpl extends JdbcDaoSupport implements CdDao{

	@Override
	public CD findById(Long id) {
		// TODO Auto-generated method stub
		return null;		
	}

	@Override
	public List<CD> findByTitle(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(CD newCd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CD updatedCd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CD updatedCd) {
		// TODO Auto-generated method stub
		
	}

}
