package com.example.Block.ServicesImpel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Block.Entity.Customer;
import com.example.Block.Repo.CustomerRepo;
import com.example.Block.Services.CustomerServices;
import com.example.Block.Validators.UserFoundException;
import com.example.Block.Validators.UserNotFoundException;

@Service
public class CustomerServicesImpel implements CustomerServices {
@Autowired
CustomerRepo custRepo;
	@Override
	public Customer addCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		Customer cust = this.custRepo.getCustomerByName(customer.getCustomer_Name());
		if(cust!= null)
		{
			 System.out.println("Shop is already there !!");
	            throw new UserFoundException();
		}
		else
		{
			cust = this.custRepo.save(customer);
			
		}
		return cust;
	}

	@Override
	public Customer checkCustomer(String name) throws Exception {
		// TODO Auto-generated method stub
		Customer cust = this.custRepo.getCustomerByName(name);
		if(cust== null)
		{
			 System.out.println("Customer is not  there !!");
			 throw new UserNotFoundException();
		}
		return cust;
	        
	}

}
