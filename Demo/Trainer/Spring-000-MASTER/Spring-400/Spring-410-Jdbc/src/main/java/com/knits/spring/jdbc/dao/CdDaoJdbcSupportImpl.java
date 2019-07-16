package com.knits.spring.jdbc.dao;

import static com.knits.spring.jdbc.dao.Queries.CD_BY_ID;
import static com.knits.spring.jdbc.dao.Queries.CD_BY_TITLE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.knits.spring.common.model.CD;
import com.knits.spring.jdbc.dao.helpers.CdRowMapper;

@Repository()
public class CdDaoJdbcSupportImpl extends JdbcDaoSupport implements CdDao{

	
	@Autowired
	private CdRowMapper cdRowMapper;
	
	@Autowired
	private DataSource dataSource;

	private SimpleJdbcInsert simpleJdbcInsert; 
	
	@PostConstruct
	public void init(){
		this.setDataSource(dataSource);	
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("CD").usingGeneratedKeyColumns("id");

	}
	
	@Override
	public CD findById(Long id) {
		return getJdbcTemplate().queryForObject(CD_BY_ID,new Object[] { id }, cdRowMapper);			
	}

	@Override
	public List<CD> findByTitle(String title) {
		return getJdbcTemplate().query(CD_BY_TITLE,new Object[] {title }, cdRowMapper);
	}

	@Override
	public Long save(CD newCd) {
		Map<String,Object> parameters = new HashMap<String,Object>();

		parameters.put("artist", newCd.getArtist());
		parameters.put("company", newCd.getCompany());
		parameters.put("country", newCd.getCountry());		
		parameters.put("price", newCd.getPrice());
		parameters.put("quantity", newCd.getQuantity());
	    parameters.put("title", newCd.getTitle());
	    parameters.put("year", newCd.getYear());	
	    parameters.put("version", 0);
	    return simpleJdbcInsert.executeAndReturnKey(parameters).longValue();
	
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
