package com.blog.entities;

import java.sql.Timestamp;

public class Post {


 private int p_id;
 public Post(int p_id, String p_name, String p_cntent, String p_img, Timestamp p_date, int c_id, String cat_name,
		int uid) {
	super();
	this.p_id = p_id;
	this.p_name = p_name;
	this.p_cntent = p_cntent;
	this.p_img = p_img;
	this.p_date = p_date;
	this.c_id = c_id;
	this.cat_name = cat_name;
	this.uid = uid;
}
private String p_name;
 private String p_cntent;
 private String p_img;
 private Timestamp p_date;
 private int c_id;
 private String cat_name;
 public String getCat_name() {
	return cat_name;
}
public void setCat_name(String cat_name) {
	this.cat_name = cat_name;
}
private int uid;
public Post(String p_name, String p_cntent, String p_img,int c_id, int uid) {
	super();
	
	this.p_name = p_name;
	this.p_cntent = p_cntent;
	this.p_img = p_img;
	
	this.c_id = c_id;
	this.uid = uid;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getP_id() {
	return p_id;
}
public void setP_id(int p_id) {
	this.p_id = p_id;
}
public String getP_name() {
	return p_name;
}
public void setP_name(String p_name) {
	this.p_name = p_name;
}
public String getP_cntent() {
	return p_cntent;
}
public void setP_cntent(String p_cntent) {
	this.p_cntent = p_cntent;
}
public String getP_img() {
	return p_img;
}
public void setP_img(String p_img) {
	this.p_img = p_img;
}
public Timestamp getP_date() {
	return p_date;
}
public void setP_date(Timestamp p_date) {
	this.p_date = p_date;
}
public int getC_id() {
	return c_id;
}
public void setC_id(int c_id) {
	this.c_id = c_id;
}
public Post() {
	super();
	// TODO Auto-generated constructor stub
}
public Post(int p_id, String p_name, String p_cntent, String p_img, Timestamp p_date, int c_id) {
	super();
	this.p_id = p_id;
	this.p_name = p_name;
	this.p_cntent = p_cntent;
	this.p_img = p_img;
	this.p_date = p_date;
	this.c_id = c_id;
}





}
