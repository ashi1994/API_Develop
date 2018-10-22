package com.model;

import java.util.Date;


public class User {
	
	
	public User(String name, String age, String add) {
		super();
		this.name = name;
		this.age = age;
		this.add = add;
	}
	private String name;
	private String age;
	private String add;
	private String id;
	private Date createdOn;
	private int trackingNumber;
	
	public User(String name, String age, Date createdOn, int trackingNumber) {
		super();
		this.name = name;
		this.age = age;
		this.createdOn = createdOn;
		this.trackingNumber = trackingNumber;
	}
	
	public User() {
		
	}
	
	
	public int getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(int trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date date) {
		this.createdOn = date;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", add=" + add + "]";
	}

	
	

}
