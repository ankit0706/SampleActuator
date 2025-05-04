package com.sample.service;

import org.springframework.stereotype.Service;
import com.sample.model.VendorRequest;
import com.sample.model.VendorResponse;

/**
 * If the request is valid, it will do some calculation based on the request params
 * and return the response
 */
@Service
public class AmountCalculationService {
	
	public VendorResponse getAmount(VendorRequest vendorRequest) {
		String product = vendorRequest.getProduct();
		int units = vendorRequest.getUnits();
		
		int rate = getRate(product);
		
		int amount = units * rate;
		
		return new VendorResponse("Your order for " + units + " of " + product, amount);
	}
	
	private int getRate(String product) {
		switch(product){
		case "biscuits and snacks":
				return 9;
		case "fruits and vegetables":
			return 15;
		default:
				return 1;
		}
	}
}
