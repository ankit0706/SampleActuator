package com.sample.service;

import org.springframework.stereotype.Service;

/**
 * Its job is to validate the id in the request
 */

@Service
public class RequestValidationService {
	
	public boolean isRequestIdValid(int requestId) {
		if(requestId > 30 && requestId < 40) {
			return true;
		}else {
			return false;
		}
	}

}
