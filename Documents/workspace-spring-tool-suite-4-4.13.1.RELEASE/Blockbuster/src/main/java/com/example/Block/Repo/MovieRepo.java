package com.example.Block.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.Block.Entity.Movie;

public interface MovieRepo extends JpaRepository<Movie,Integer> {
	
	@Query("select m from Movie m where m.Movie_Name= :movie_name")
	public Movie getMovieByName(@Param("movie_name") String movie_name);

}
