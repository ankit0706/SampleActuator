package com.sample.model;

public class ResultResponse {
	
	private String result;
	
	private String description;

	public ResultResponse(String result, String description) {
		super();
		this.result = result;
		this.description = description;
	}

	public String getResult() {
		return result;
	}

	public String getDescription() {
		return description;
	}
}
