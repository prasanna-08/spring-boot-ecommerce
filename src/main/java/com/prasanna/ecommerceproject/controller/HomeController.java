package com.prasanna.ecommerceproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index()						//Use @RestController when building REST APIs that return JSON, XML, or plain text responses.
												//Use @Controller when working with Thymeleaf, JSP, or other template engines to return HTML views.
	{
		return "index";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
	
}
