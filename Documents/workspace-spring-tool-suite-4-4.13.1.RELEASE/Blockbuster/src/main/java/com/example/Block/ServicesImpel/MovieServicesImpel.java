package com.example.Block.ServicesImpel;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Block.Validators.UserNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Block.Entity.Movie;
import com.example.Block.Repo.MovieRepo;
import com.example.Block.Services.MovieServices;
import com.example.Block.Validators.UserFoundException;

@Service
public class MovieServicesImpel implements MovieServices{

	@Autowired
	MovieRepo movieRepo;
	@Override
	public Movie addMovie(Movie movie) throws Exception {
		Movie mov = movieRepo.getMovieByName(movie.getMovie_Name());
		if (mov!= null)
		{
			   System.out.println("Movie is already there !!");
	            throw new UserFoundException();
		}
		else
		{
			mov = this.movieRepo.save(movie);
		}
		
		return mov;
	}
	@Override
	public Movie checkMovie(String name) throws Exception {
		// TODO Auto-generated method stub
		Movie mov = movieRepo.getMovieByName(name);
		if (mov== null)
		{
			   System.out.println("Movie is already there !!");
	            throw new UserNotFoundException();
		}
		return mov;

}
	}
