package com.example.Block.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Block.Entity.Customer;
import com.example.Block.Entity.Employee;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
	@Query("select c from Customer c where c.Customer_Name= :customer_name")
	public Customer getCustomerByName(@Param("customer_name") String customer_name);

}
