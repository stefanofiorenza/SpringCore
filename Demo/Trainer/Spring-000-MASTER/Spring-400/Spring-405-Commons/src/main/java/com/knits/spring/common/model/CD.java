package com.knits.spring.common.model;

import lombok.Data;

@Data
public class CD {

	private Long PrimaryKey;
	private String artist;
	private String company;
	private String country;
	private double price;
	private String title;
	private int year;
	private int quantity;
	
	
}
