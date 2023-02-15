package com.example.MiniProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.MiniProject.Entity.Admin;
import com.example.MiniProject.Entity.Customer;
import com.example.MiniProject.controller.DefaultForLogin;
import com.example.MiniProject.dao.AdminRepository;
import com.example.MiniProject.dao.CusttomerRepository;

public class UserDetailsServiceImplmnt implements UserDetailsService {

	@Autowired
	private CusttomerRepository custRepo;
	
	DefaultForLogin def = new DefaultForLogin();
	@Autowired
	private AdminRepository adminRepo;
	@Override
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Customer customer = custRepo.getUserByUserName(username);
		Admin admin = adminRepo.getUserByUserName(username);
		
		
		CustomeUserDetails customerUserDetails;
		AdminUserDetails adminUserDetails;
		
		if(admin!= null) 
		{
			adminUserDetails = new AdminUserDetails(admin);
			
			def.for_login(admin.getaUserName(),admin.getaPassword());
			return adminUserDetails;

			 		}
		else
		{
			
			if (customer== null)
			{
								throw new UsernameNotFoundException("Could not found user !!");
			}
				
			customerUserDetails = new CustomeUserDetails(customer);
			def.for_login(customer.getcUserName(),customer.getcPassword());


			
			return customerUserDetails;


		}
		
	}

}
