package com.knits.spring.jdbc.dao;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.knits.spring.common.model.CD;
import com.knits.spring.jdbc.dao.helpers.CdRowMapper;

import static com.knits.spring.jdbc.dao.Queries.CD_BY_ID;
import static com.knits.spring.jdbc.dao.Queries.CD_BY_TITLE;

@Repository
public class CdDaoJdbcTemplate implements CdDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CdRowMapper cdRowMapper;
	
	
	
	@Override
	public CD findById(Long id) {
		return jdbcTemplate.queryForObject(CD_BY_ID,new Object[] { id }, cdRowMapper);			
	}

	@Override
	public List<CD> findByTitle(String title) {
		return jdbcTemplate.query(CD_BY_TITLE,new Object[] {title }, cdRowMapper);	
	}

	@Override
	public Long save(CD newCd) {
		throw new UnsupportedOperationException("Not yet implemented");		
	}

	@Override
	public void update(CD updatedCd) {
		throw new UnsupportedOperationException("Not yet implemented");			
	}

	@Override
	public void delete(CD updatedCd) {
		throw new UnsupportedOperationException("Not yet implemented");		
	}

}
