package com.blog.helper;

public class Message {


	private String mesg;
	private String style;
	public Message(String mesg, String style) {
		super();
		this.mesg = mesg;
		this.style = style;
	}
	public String getMesg() {
		return mesg;
	}
	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}


}
