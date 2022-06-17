package com.example.Block.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import com.example.Block.Entity.Employee;
import com.example.Block.Entity.Shop;



public interface ShopRepo extends JpaRepository<Shop,Integer>{
	@Query("select s from Shop s where s.Shop_Name = :shop_name")
	public Shop getShopById(@Param("shop_name") String shop_name);


}
