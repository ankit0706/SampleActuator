package com.sample.model;

public class Header {
	
	private int id;
	private String date;
	private String sender;
	
	public Header(int id, String date, String sender) {
		super();
		this.id = id;
		this.date = date;
		this.sender = sender;
	}

	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getSender() {
		return sender;
	}
	
	
}
