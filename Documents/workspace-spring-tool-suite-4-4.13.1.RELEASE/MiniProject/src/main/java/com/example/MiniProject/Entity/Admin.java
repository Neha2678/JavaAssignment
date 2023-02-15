package com.example.MiniProject.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Admin")
public class Admin {

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aId;
	private String role;
	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "admin")
	@JsonIgnore
	private Set<Product> products = new HashSet<>();
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Admin(int aId, String aUserName, String aPassword) {
		super();
		this.aId = aId;
		this.aUserName = aUserName;
		this.aPassword = aPassword;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaUserName() {
		return aUserName;
	}
	public void setaUserName(String aUserName) {
		this.aUserName = aUserName;
	}
	public String getaPassword() {
		return aPassword;
	}
	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}
	@Column(unique=true)
	private String aUserName;
	
	private String aPassword;
	
	
	
}
