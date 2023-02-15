package com.example.MiniProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.MiniProject.Entity.Customer;


public interface CusttomerRepository extends JpaRepository<Customer,Integer>{

	@Query("select c from Customer c where c.email =:email")
	public Customer getUserByUserName(@Param("email") String email);
}
