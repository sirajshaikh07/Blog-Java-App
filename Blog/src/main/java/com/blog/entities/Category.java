package com.blog.entities;

public class Category {


	private int cid;
	private String ctype;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public Category(int cid, String ctype) {
		super();
		this.cid = cid;
		this.ctype = ctype;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String ctype) {
		super();
		this.ctype = ctype;
	}





}
