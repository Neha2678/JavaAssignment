package com.example.MiniProject.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import org.hibernate.mapping.Set;



@Entity
@Table(name = "Customer")
public class Customer {

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cId;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "customer")
	@JsonIgnore
	private Set<CustomerCart> cart = new HashSet<>();
	
	

	
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", cart=" + cart + ", cUserName=" + cUserName + ", cPassword=" + cPassword
				+ ", description=" + description + "]";
	}

	public Set<CustomerCart> getCart() {
		return cart;
	}

	public void setCart(Set<CustomerCart> cart) {
		this.cart = cart;
	}

	public Customer(int cId, String cUserName, String cPassword, String description) {
		super();
		this.cId = cId;
		this.cUserName = cUserName;
		this.cPassword = cPassword;
		this.description = description;
	}
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcUserName() {
		return cUserName;
	}
	public void setcUserName(String cUserName) {
		this.cUserName = cUserName;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@NotBlank(message = "Name field is required !!")
	@Size(min = 2,max = 50,message = "min 2 and max 20 characters are allowed !!")
	private String cUserName;
	private String cPassword;
	
	@Column(unique = true)
	private String email;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 1000)
	private String description;

	private String role;




	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
