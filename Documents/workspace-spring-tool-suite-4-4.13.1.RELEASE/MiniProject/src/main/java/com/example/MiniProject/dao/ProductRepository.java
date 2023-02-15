package com.example.MiniProject.dao;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.MiniProject.Entity.Product;
import com.example.MiniProject.Entity.Admin;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	@Query("from Product as p where p.admin.aId =:aId")
	public Page<Product> findProductsbyAdmin(@Param("aId")int aId, Pageable pPageable);
}
