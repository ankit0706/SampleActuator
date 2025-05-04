package com.sample.actuator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sample.model.VendorRequest;
import com.sample.model.VendorResponse;
import com.sample.service.AmountCalculationService;
import com.sample.service.RequestValidationService;
import jakarta.validation.Valid;

/**
 * Controller will receive the request which will be in json format
 * There are 2 validations to be performed on the request. First there will be an id in the request which has to be in a fixed range
 * and then there are some mandatory fields. If these validations fail, a customized error response has to be sent.
 * Otherwise, the request will be processed and its successful response will be sent.
 */

@RestController
public class VendorController{
	
	@Autowired
	RequestValidationService validationService;
	
	@Autowired
	AmountCalculationService calculationService;			
	
	/*
	 * endpoint simply receives and request and send response
	 * any validation or amendment will be done by the services
	 */
	@PostMapping("/basic")
	public VendorResponse getBasic(@Valid @RequestBody VendorRequest req) {
		if(validationService.isRequestIdValid(req.getHeader().getId())) {
			return calculationService.getAmount(req);
		}else {
			return new VendorResponse("Invalid Request Id", 0);
		}
	}
	
	/*
	 * custom exception handler: since it's defined locally, it will only be applicable
	 * for exceptions occurring at this controller's level. Here, in case json request
	 * is missing mandatory fields, we will catch the exception here and send a custom 
	 * response to the client
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public VendorResponse handleSchemaError() {
		return new VendorResponse("Inavlid Json Request", 404);
	}

}
