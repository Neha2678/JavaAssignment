package com.example.Block.Entity;

import java.util.Date;
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
@Table(name= "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Customer_Id;
	private String Customer_Name;
	private String Customer_Adress;
	private String Customer_DOB;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "customer")
	@JsonIgnore
	private Set<Rents> rent = new HashSet<>();
	public int getCustomer_Id() {
		return Customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		Customer_Id = customer_Id;
	}
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	public String getCustomer_Adress() {
		return Customer_Adress;
	}
	public void setCustomer_Adress(String customer_Adress) {
		Customer_Adress = customer_Adress;
	}
	public String getCustomer_DOB() {
		return Customer_DOB;
	}
	public void setCustomer_DOB(String customer_DOB) {
		 Customer_DOB = customer_DOB;
	}
	public Set<Rents> getRent() {
		return rent;
	}
	public void setRent(Set<Rents> rent) {
		this.rent = rent;
	}
	@Override
	public String toString() {
		return "Customer [Customer_Id=" + Customer_Id + ", Customer_Name=" + Customer_Name + ", Customer_Adress="
				+ Customer_Adress + ", Customer_DOB=" + Customer_DOB + ", rent=" + rent + "]";
	}
	
}
