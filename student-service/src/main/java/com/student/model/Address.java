package com.student.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {
	
	@Id
	private String id;

	
	private String street;

	private String city;
	
	

	public Address() {
		super();
	}

	public Address(String id, String street, String city) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


}
