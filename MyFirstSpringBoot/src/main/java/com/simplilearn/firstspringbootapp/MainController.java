package com.simplilearn.firstspringbootapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@GetMapping("hello")
	public String hello() {
		return "Welcome from spring boot app";
	}

}

