package com.example.Block.Services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.Block.Entity.Shop;
import com.example.Block.Entity.Catalogue;

public interface ShopServices {

	public Shop addShop(Shop shop) throws Exception;
	public Shop checkShop(String name)throws Exception;
	public Shop updateShop(Shop shop) throws Exception;
	public Shop addMovies(Shop shop,Set<Catalogue> movieList) throws Exception;
	public Shop checkMovies(Shop shop,Set<Catalogue> movieList) throws Exception;

}
