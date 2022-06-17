package com.example.Block.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Block.Entity.Movie;
import com.example.Block.Services.MovieServices;

@Controller
public class MovieController {
	@Autowired
	MovieServices movieService;
	@RequestMapping("/addMovie")
	//adding movies
	//duplicate name not allowed 
	public String addMovie() throws Exception
	{
		/*Movie movie = new Movie();
		movie.setMovie_Name("Changeling");
		movie.setMovie_RatingS("A");
		this.movieService.addMovie(movie);*/
		return "add_Shop";
	}

}
