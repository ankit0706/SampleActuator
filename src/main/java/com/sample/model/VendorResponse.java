package com.sample.model;

public class VendorResponse {
	
	private String status;
	private int amount;
	
	public VendorResponse(String status, int amount) {
		super();
		this.status = status;
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public int getAmount() {
		return amount;
	}
	
	
}
