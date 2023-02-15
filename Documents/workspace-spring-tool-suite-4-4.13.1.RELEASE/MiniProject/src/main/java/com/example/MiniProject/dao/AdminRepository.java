package com.example.MiniProject.dao;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.MiniProject.Entity.Admin;
import com.example.MiniProject.Entity.Customer;

public interface AdminRepository extends JpaRepository<Admin,Integer>{
	
	@Query("select a from Admin a where a.aUserName = :aUserName")
	public Admin getUserByUserName(@Param("aUserName") String aUserName);
	}
