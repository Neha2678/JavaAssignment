package com.example.MiniProject.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
//@PreAuthorize("hasRole('customer')")
public class CustomerController {
	
	@GetMapping("/index")
	public String dashboard()
	{
		return "customer";
	}
	

}


