package com.example.Block.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "shop")
public  class Shop {
	
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Shop_Id;
	private String Shop_Name;
	private String Shop_Adress;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "shop")
	@JsonIgnore
	private Set<Employee> employees = new HashSet<>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "shop")
	@JsonIgnore
	private Set<Rents> rent = new HashSet<>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "shop")
	@JsonIgnore
	private Set<Catalogue> cat = new HashSet<>();
	public int getShop_Id() {
		return Shop_Id;
	}
	public void setShop_Id(int shop_Id) {
		Shop_Id = shop_Id;
	}
	public String getShop_Name() {
		return Shop_Name;
	}
	public void setShop_Name(String shop_Name) {
		Shop_Name = shop_Name;
	}
	public String getShop_Adress() {
		return Shop_Adress;
	}
	public void setShop_Adress(String shop_Adress) {
		Shop_Adress = shop_Adress;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Set<Rents> getRent() {
		return rent;
	}
	public void setRent(Set<Rents> rent) {
		this.rent = rent;
	}
	public Set<Catalogue> getCat() {
		return cat;
	}
	public void setCat(Set<Catalogue> cat) {
		this.cat = cat;
	}
	@Override
	public String toString() {
		return "Shop [Shop_Id=" + Shop_Id + ", Shop_Name=" + Shop_Name + ", Shop_Adress=" + Shop_Adress + ", employees="
				+ employees + ", rent=" + rent + ", cat=" + cat + "]";
	}

}
