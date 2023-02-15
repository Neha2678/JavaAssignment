package com.example.MiniProject.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "cart")
public class CustomerCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long CartID;
	
	public long getCartID() {
		return CartID;
	}

	public void setCartID(long cartID) {
		CartID = cartID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Product product;


}
