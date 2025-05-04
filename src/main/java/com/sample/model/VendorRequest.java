package com.sample.model;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
/**
 * model class for the json request.
 * we have made the product field mandatory in this request.
 * if product is missing or not in specified size, it will result in
 * BAD_REQUEST 404 which will be handled by custom handler at controller
 * level
 */
public class VendorRequest {
	
	private Header header;
	
	@NotBlank(message = "Must provide product")
	@Size(min = 10, max = 50, message = "Name must be between 10 and 50 characters")
	private String product;
		
	private int units;
	
	private List<String> brands;

	public VendorRequest(Header header, String product, int units, List<String> brands) {
		super();
		this.header = header;
		this.product = product;
		this.units = units;
		this.brands = brands;
	}	

	public Header getHeader() {
		return header;
	}

	public String getProduct() {
		return product;
	}

	public int getUnits() {
		return units;
	}
	
	public List<String> getBrands() {
		return brands;
	}

}
