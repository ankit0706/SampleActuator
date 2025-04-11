package com.sample.actuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController{
	
	@GetMapping("/square")
	public int getSquare(@RequestParam(value="number") int input) {
		return input * input;
	}

}
