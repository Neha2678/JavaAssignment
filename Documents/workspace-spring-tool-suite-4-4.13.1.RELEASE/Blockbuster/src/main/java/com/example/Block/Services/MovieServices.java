package com.example.Block.Services;

import com.example.Block.Entity.Movie;
import com.example.Block.Entity.Shop;

public interface MovieServices {

	public Movie addMovie(Movie movie) throws Exception;
	public Movie checkMovie(String name)throws Exception;
}
