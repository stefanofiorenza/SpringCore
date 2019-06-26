package com.knits.spring.jdbc.dao.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.knits.spring.common.model.CD;

public class CdRowMapper implements RowMapper<CD>{

	
	@Override
	public CD mapRow(ResultSet rs, int rowNum) throws SQLException {
		CD cd = new CD();
		cd.setArtist(rs.getString("Artist"));
		cd.setTitle(rs.getString("Title"));	
		cd.setCompany(rs.getString("company"));
		cd.setCountry(rs.getString("country"));
		cd.setPrice(rs.getDouble("price"));
		cd.setQuantity(rs.getInt("quantity"));
		cd.setYear(rs.getInt("year"));
		return cd;
	}

}
