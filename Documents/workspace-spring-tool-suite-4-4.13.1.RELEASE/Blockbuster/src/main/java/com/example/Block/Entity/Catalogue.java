package com.example.Block.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "cat")
public class Catalogue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Cat_Id;
	private int copies;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Movie movie;
	
	public int getCat_Id() {
		return Cat_Id;
	}

	public void setCat_Id(int cat_Id) {
		Cat_Id = cat_Id;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	private Shop shop;

	@Override
	public String toString() {
		return "Catalogue [Cat_Id=" + Cat_Id + ", copies=" + copies + ", movie=" + movie + ", shop=" + shop + "]";
	}

}
