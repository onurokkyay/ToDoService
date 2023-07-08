package com.krawen.todoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@GetMapping("/auth/basic")
	public String checkBasicAuth() {
		return "Success";
	}
}
