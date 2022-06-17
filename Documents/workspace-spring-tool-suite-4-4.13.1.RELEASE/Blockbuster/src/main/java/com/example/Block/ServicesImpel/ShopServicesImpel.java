package com.example.Block.ServicesImpel;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Block.Entity.Catalogue;
import com.example.Block.Entity.Movie;
import com.example.Block.Entity.Shop;
import com.example.Block.Repo.MovieRepo;
import com.example.Block.Repo.ShopRepo;
import com.example.Block.Services.ShopServices;
import com.example.Block.Validators.UserFoundException;
import com.example.Block.Validators.UserNotFoundException;

@Service
public class ShopServicesImpel implements ShopServices{

	@Autowired
	ShopRepo shopRepo;
	@Autowired
	MovieRepo movieRepo;
	@Autowired
	Catalogue catRepo;
	@Override
	public Shop addShop(Shop shop) throws Exception {
		// TODO Auto-generated method stub
		Shop sh = this.shopRepo.getShopById(shop.getShop_Name());
		if(sh!= null)
		{
			 System.out.println("Shop is already there !!");
	            throw new UserFoundException();
		}
		else
		{
			sh = this.shopRepo.save(shop);
			
		}
		return sh;
	}
	@Override
	public Shop checkShop(String name) throws Exception {
		// TODO Auto-generated method stub
		Shop sh = this.shopRepo.getShopById(name);
		if(sh!= null)
		{
			return sh;
		}
		else
		return null;
	}
	@Override
	public Shop updateShop(Shop shop) throws Exception {
		// TODO Auto-generated method stub
		Shop sh = this.shopRepo.save(shop);
		return sh;
	}
	@Override
	public Shop addMovies(Shop shop, Set<Catalogue> movieList) throws Exception {
		// TODO Auto-generated method stub
		Shop sh = this.shopRepo.getShopById(shop.getShop_Name());
		if(sh==null)
		{
			System.out.println("Shop is not there !!");
            throw new UserNotFoundException();
		}
		
		else
		{
			for(Catalogue cat: movieList)
			{
				Movie m = cat.getMovie();
				Movie m1 = movieRepo.getMovieByName(m.getMovie_Name());
				if(m1==null)
				{
					System.out.println("Movie is not there !!");
		            throw new UserNotFoundException();
				}
				
			}
			shop.getCat().addAll(movieList);
			sh = this.shopRepo.save(shop);
			
		}
		return sh;
	}
	@Override
	public Shop checkMovies(Shop shop, Set<Catalogue> movieList) throws Exception {
		// TODO Auto-generated method stub

		for(Catalogue cat: movieList)
		{
			Movie m = cat.getMovie();
		//	Movie m1 =catRepo.
		/*	if(m1==null)
			{
				System.out.println("Movie is not there !!");
	            throw new UserNotFoundException();
			}*/
			
		}
		return null;
	}

}
