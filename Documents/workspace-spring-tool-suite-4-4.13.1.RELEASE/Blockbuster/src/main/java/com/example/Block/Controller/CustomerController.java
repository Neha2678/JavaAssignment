package com.example.Block.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Block.Entity.Customer;
import com.example.Block.Services.CustomerServices;

@Controller
public class CustomerController {

	@Autowired
	CustomerServices custService;
	@RequestMapping("/addCust")
	public String addCustomer()
	{
		Customer cust = new Customer();
		cust.setCustomer_Name("Neha");
		cust.setCustomer_Adress("Powai");
		cust.setCustomer_DOB("06/07/1996");
		
		return "add_Shop";
	}
}
