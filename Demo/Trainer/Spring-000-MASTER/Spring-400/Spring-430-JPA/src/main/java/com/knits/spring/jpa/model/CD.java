package com.knits.spring.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CD {

	@Id
	private Long id;
	
	private String artist;
	private String company;
	private String country;
	private double price;
	private String title;
	private int year;
	private int quantity;
	
	
}
