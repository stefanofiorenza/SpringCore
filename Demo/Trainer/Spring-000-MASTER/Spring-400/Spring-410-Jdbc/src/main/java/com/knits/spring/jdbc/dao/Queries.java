package com.knits.spring.jdbc.dao;

public class Queries {

	
	public static final String CD_BY_ID="select * from CD where id=?";	
	public static final String CD_BY_TITLE="select * from cd where title=?";
	
	
	public static final String CD_INSERT="INSERT INTO CD "
			+ "(Artist, Company, Price, Title, Country, Year, Quantity, Version) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	
	
}
