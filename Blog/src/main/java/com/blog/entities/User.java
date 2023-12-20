package com.blog.entities;

import java.sql.Timestamp;

public class User {

	private String name;
	private String email;
	private String password;
	private String about;
	private String image;
	private int udi;
	private String gender;
	private Timestamp date;

	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public User(String name, String email, String password, String about, String image) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
		this.image = image;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public int getUdi() {
		return udi;
	}
	public void setUdi(int udi) {
		this.udi = udi;
	}







}
