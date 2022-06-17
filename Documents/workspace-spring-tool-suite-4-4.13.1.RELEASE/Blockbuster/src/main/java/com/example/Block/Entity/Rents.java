package com.example.Block.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name= "rent")
public class Rents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Rent_id;
	public int getRent_id() {
		return Rent_id;
	}

	public void setRent_id(int rent_id) {
		Rent_id = rent_id;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	private int days;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Shop shop;
	@Override
	public String toString() {
		return "Rents [Rent_id=" + Rent_id + ", days=" + days + ", customer=" + customer + ", shop=" + shop + "]";
	}

}
