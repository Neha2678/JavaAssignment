package com.example.Block.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Block.Entity.Catalogue;
import com.example.Block.Entity.Employee;
import com.example.Block.Entity.Movie;

public interface CatalogueRepo  extends JpaRepository<Catalogue,Integer>{
	
	@Query("select e from Catalogue e where e.Movie= :movie")
	public Catalogue getCatalogueById(@Param("movie") Movie movie);


}



