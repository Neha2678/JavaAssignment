package com.example.MiniProject.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MiniProject.Entity.Admin;
import com.example.MiniProject.Entity.Customer;
import com.example.MiniProject.dao.AdminRepository;
import com.example.MiniProject.dao.CusttomerRepository;

@Controller

public class DefaultForLogin {
	Admin admin;
	@Autowired
	AdminRepository adminRepository;
	Customer customer;
	@Autowired
	CusttomerRepository customerRepository;
	@GetMapping("/default")
	public String defaultAfterLogin(HttpServletRequest request,Principal principal) throws IOException, ServletException {
		//Getting username 
		String username = principal.getName();
		//String cusername = null;
		//
		
		//String user = for_login(username,password);
	
		
	    //get username and password manually from Authorization header
	    //...
	    //request.login(username,password);
	   
		// System.out.println(username);
		admin = adminRepository.getUserByUserName(username);
		customer = customerRepository.getUserByUserName(username);

		
		if(admin!= null)
		{
			
			
			return "redirect:/admin/auth";
		}
		else if (customer!= null)
		{
		return "redirect:/customer/index";
		}
		else
			
		return null;
		
	}

	public String for_login(String username,String password)
	{
		return username;
	}
	
	
}
