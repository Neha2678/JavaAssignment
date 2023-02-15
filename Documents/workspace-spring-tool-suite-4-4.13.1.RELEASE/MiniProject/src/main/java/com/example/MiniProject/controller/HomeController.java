package com.example.MiniProject.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.MiniProject.helper.Message;
import com.example.MiniProject.Entity.Admin;
import com.example.MiniProject.Entity.Customer;
import com.example.MiniProject.dao.AdminRepository;
import com.example.MiniProject.dao.CusttomerRepository;

/*import org.springframework.web.bind.annotation.ResponseBody;
import com.example.MiniProject.dao.*;
import com.example.MiniProject.Entity.*;
*/
@Controller

public class HomeController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private  CusttomerRepository customerRepository;
	
	
	
	
	@Autowired
	private AdminRepository adminRepository;
	
	
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}

	@RequestMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("title", "On my portal");
		model.addAttribute("customer",new Customer());
		return "signup";
	}
	
	@RequestMapping(value = "/do_register", method = RequestMethod.POST)

	public String RegisterCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult result1,@RequestParam(value = "agreement", defaultValue = "false") boolean agreement,Model model,HttpSession Session)
	{
		System.out.print("User added"+customer);
		customer.setRole("customer");
		
		try {

			if (!agreement) {
				System.out.println("You have not agreed the terms and conditions");
				throw new Exception("You have not agreed the terms and conditions");
			}

			if (result1.hasErrors()) {
				System.out.println("ERROR " + result1.toString());
				model.addAttribute("customer", customer);
				return "signup";
			}
			customer.setRole("customer");
			customer.setcPassword(passwordEncoder.encode(customer.getcPassword()));
			Customer cust = this.customerRepository.save(customer);
			
			/*Admin admin = new Admin();
			admin.setaUserName("Nehu");
			admin.setaPassword(passwordEncoder.encode("Desi"));
			admin.setRole("Admin");
			adminRepository.save(admin);*/
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("customer", customer);
			Session.setAttribute("message", new Message("Something Went wrong !! " + e.getMessage(), "alert-danger"));
			return "signup";

		
		
			}
		return "signup";
}
	@GetMapping("/signin")
	public String customLogin(Model model)
	{
		model.addAttribute("title","Login Page");
		return "login";
	}
	
	/*@GetMapping("/customer")
	public String cLogin(Model model)
	{
		model.addAttribute("title","Login Page");
		return "customer";
	}*/
	
}
