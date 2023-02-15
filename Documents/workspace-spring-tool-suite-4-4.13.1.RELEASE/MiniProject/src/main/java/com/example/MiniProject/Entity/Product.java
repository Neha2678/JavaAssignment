package com.example.MiniProject.Entity;

import java.util.*;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Product")

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	private String pName;
	private String  pType;
	private String pQuantity;
	private String pDescription;
	private String pPrice;
	private String pImage;
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public String getpPrice() {
		return pPrice;
	}
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	
	//private String image;
	
	
	public String getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(String pQuantity) {
		this.pQuantity = pQuantity;
	}
	/*public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}*/
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "product")
	private Set<CustomerCart> product = new HashSet<>();
	@ManyToOne(fetch = FetchType.EAGER)
	private Admin admin;
	
	
	
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Set<CustomerCart> getProduct() {
		return product;
	}
	public void setProduct(Set<CustomerCart> product) {
		this.product = product;
	}
		public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
		public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
}
