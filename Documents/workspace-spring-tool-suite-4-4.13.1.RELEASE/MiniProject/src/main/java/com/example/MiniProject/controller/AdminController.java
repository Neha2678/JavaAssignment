package com.example.MiniProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//import org.junit.jupiter.api.Test;

//import org.springframework.boot.test.context.SpringBootTest;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.example.MiniProject.Entity.Admin;
import com.example.MiniProject.Entity.Product;
import com.example.MiniProject.dao.AdminRepository;
import com.example.MiniProject.dao.ProductRepository;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

//import com.example.SmartContact.dao.UserRepository;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;




@Controller

public class AdminController implements ErrorController {
	Admin admin;
	String userName;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping("/auth")
	//Redirects here after login
	public String addCommonData(Principal principal) {
		// userName = principal.getName();
	/*	System.out.println("USERNAME " + userName);

		// get the user using usernamne(Email)

		Admin admin = adminRepository.getUserByUserName(userName);*/
		
		return "Admins/dashboard";

	}
	//@RequestMapping("/auth")
	public String dashboard(Model model)
	{
		//String userName =principal.getName();
	//	
		return "Admins/dashboard";
	}
	/*@RequestMapping("/addproduct")
	public String openAddProduct(Model model)
	
	{
		//model.addAttribute("title","We add products");
		return "Admins/dashboard";
		
	}*/
	
	@RequestMapping("/add_product")
//Adding the product form	
public String AddProduct(Model model)
	
	{
		//model.addAttribute("title","We add products");
		model.addAttribute("title", "Add Product");
		model.addAttribute("product", new Product());
		

		return "Admins/addProduct";
		
	}
	//@ModelAttribute
	//Proces the form and save it to database
	@PostMapping("/process_product")
	public String ProcessProduct(@ModelAttribute Product product, Principal principal,
			 @RequestParam("Image") MultipartFile file,		HttpSession session)
	{
		try
		{
		//String name = principal.getName();
		
		Admin admin = this.adminRepository.getUserByUserName(userName);
		admin.getProducts().add(product);
		product.setAdmin(admin);
		this.adminRepository.save(admin);
		
		// processing and uploading file..

					if (file.isEmpty()) {
						// if the file is empty then try our message
						System.out.println("File is empty");
						product.setpImage("product.png");

					} else {
						// file the file to folder and update the name to contact
						product.setpImage(file.getOriginalFilename());

						File saveFile = new ClassPathResource("static/img").getFile();

						Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

						Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

						System.out.println("Image is uploaded");

					}

		System.out.println("Data"+product);
		}
		catch (Exception e)
		{
			System.out.println("ERROR " + e.getMessage());
			e.printStackTrace();
			// message error
			//session.setAttribute("message", new Message("Some went wrong !! Try again..", "danger"));
			
		}
		return "Admins/addProduct";
		//return "Admins/processproduct";
	}
	
	//Showing all products using pagination
	@RequestMapping("/show_products/{page}")
	public String showProducts(@PathVariable("page") Integer page, Model m)
	{
		Admin admin = this.adminRepository.getUserByUserName(userName);
		Pageable pageable = PageRequest.of(page, 5);
		Page <Product> Products = this.productRepository.findProductsbyAdmin(admin.getaId(),pageable);
		
		m.addAttribute("products", Products);
		m.addAttribute("currentPage", page);
		m.addAttribute("totalPages",  Products.getTotalPages());


		return "Admins/showProducts";
	}
}
