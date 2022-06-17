package com.example.Block.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Block.Entity.Catalogue;
import com.example.Block.Entity.Customer;
import com.example.Block.Entity.Employee;
import com.example.Block.Entity.Movie;
import com.example.Block.Entity.Shop;
import com.example.Block.Services.CustomerServices;
import com.example.Block.Services.EmployeeServices;
import com.example.Block.Services.MovieServices;
import com.example.Block.Services.ShopServices;


@Controller
public class ShopController {
	@Autowired
	private ShopServices shopService;
	@Autowired
	private EmployeeServices empService;
	@Autowired
	private MovieServices movieService;
	@Autowired
	private CustomerServices custService;
	//Shop shop;
	//adding shops, duplicate name isn't allowed 
	@RequestMapping("/addShop")
	public String addShop() throws Exception
	{
	Shop shop = new Shop();
		/*shop.setShop_Name("B1");
		shop.setShop_Adress("Bandra");
		 this.shopService.addShop(shop);*/
		 return "add_Shop";
	}
	//adding manager to each shop
	//for now considering each employee has a unique name
	//commenting them because after adding again they throw error
	@RequestMapping("/addManager")
	public String addManager() throws Exception
	{
		/*Employee emp = new Employee();
		emp.setEmployee_Name("Rohit");
		emp.setEmployee_Role("Manager");
		emp.setEmployee_Shift("Day");
		this.empService.addEmployee(emp);
		
		Shop shop = this.shopService.checkShop("B2");
		if(shop!= null)
		{
			shop.getEmployees().add(emp);
			emp.setShop(shop);
			this.shopService.updateShop(shop);
		}*/
		
		return "add_Shop";
	}
	//adding employee
	
	@RequestMapping("/addEmployee")
	public String addEmployee() throws Exception
	{
		Employee emp = new Employee();
		emp.setEmployee_Name("Mukesh");
		emp.setEmployee_Role("Counter staff");
		emp.setEmployee_Shift("Day");
		this.empService.addEmployee(emp);
		
		Shop shop = this.shopService.checkShop("B1");
		if(shop!= null)
		{
			shop.getEmployees().add(emp);
			emp.setShop(shop);
			this.shopService.updateShop(shop);
		}
		
		return "add_Shop";
	}
	
//adding movies to shops
	@RequestMapping("/addMoviesshop")
	public String addMoviesShop() throws Exception
	{
		Set<Catalogue> cats = new HashSet<>();
		//assigning movies to shop and checking whether movie is in database or not
		
		/*Shop shop = this.shopService.checkShop("B1");
		Movie movie = this.movieService.checkMovie("Changeling");
		Catalogue cat = new Catalogue();
		if(shop!= null&& movie!=null)
		{
			cat.setMovie(movie);
			cat.setShop(shop);
			cat.setCopies(15);
			cats.add(cat);
			this.shopService.addMovies(shop, cats);
		}*/
		
		return "add_Shop";
	}
	
	@RequestMapping("/rentMovies")
	public String rentMovies() throws Exception
	{
		Set<Catalogue> cats = new HashSet<>();
		//assigning movies to shop and checking whether movie is in database or not
		Customer cust = this.custService.checkCustomer("Neha");
		Shop shop = this.shopService.checkShop("B1");
		Movie movie = this.movieService.checkMovie("Changeling");
		movie.getMovie_Id();
		Catalogue cat = new Catalogue();
		cat.setShop(shop);
		cat.setMovie(movie);
		cats.add(cat);
		this.shopService.checkMovies(shop, cats);
		
		
		return "add_Shop";
	}
	

	@RequestMapping("/displayMovies")
	public String displayMovies() throws Exception
	{
		Set<Catalogue> cats = new HashSet<>();
		Shop shop = this.shopService.checkShop("B1");
		
		Catalogue cat = new Catalogue();
		cat.setShop(shop);
		
		cats.add(cat);
		this.shopService.checkMovies(shop, cats);
		
		
		return "add_Shop";
	}
	

}
