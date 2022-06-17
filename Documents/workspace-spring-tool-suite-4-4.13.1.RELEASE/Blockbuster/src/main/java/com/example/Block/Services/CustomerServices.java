package com.example.Block.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Block.Entity.Customer;
import com.example.Block.Entity.Shop;


public interface CustomerServices {
	public Customer addCustomer(Customer customer) throws Exception;
	public Customer checkCustomer(String name)throws Exception;

}
