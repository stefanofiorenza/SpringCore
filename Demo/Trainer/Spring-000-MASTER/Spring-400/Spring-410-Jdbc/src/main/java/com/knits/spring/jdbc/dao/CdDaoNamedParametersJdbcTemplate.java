package com.knits.spring.jdbc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.knits.spring.common.model.CD;
import com.knits.spring.jdbc.dao.helpers.CdRowMapper;

import static com.knits.spring.jdbc.dao.Queries.CD_BY_ID;
import static com.knits.spring.jdbc.dao.Queries.CD_BY_TITLE;

@Repository
public class CdDaoNamedParametersJdbcTemplate implements CdDao{

	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
		
	@Autowired
	private CdRowMapper cdRowMapper;
	
	private SimpleJdbcInsert simpleJdbcInsert; 
	
	
	@PostConstruct
	public void init() {
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("CD").usingGeneratedKeyColumns("id");
	}
	
	@Override
	public CD findById(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return namedJdbcTemplate.queryForObject("select * from CD where id=:id", params, cdRowMapper);	
	}

	@Override
	public List<CD> findByTitle(String title) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("title", title);
		return namedJdbcTemplate.query("select * from CD where title=:title", namedParameters,cdRowMapper);
	}

	
	@Override
	public Long save(CD newCd) {
	        
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("title", newCd.getTitle());
		parameters.put("artist", newCd.getArtist());
		parameters.put("country", newCd.getCountry());
		parameters.put("company", newCd.getCompany());
		parameters.put("price", newCd.getPrice());
		parameters.put("quantity", newCd.getQuantity());
		parameters.put("year", newCd.getYear());
		parameters.put("version", 0);

		return simpleJdbcInsert.executeAndReturnKey(parameters).longValue();		    
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
