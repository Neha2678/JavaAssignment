package com.example.Block.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name= "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Employee_Id;
	private String Employee_Name;
	private String Employee_Role;
	private String Employee_Shift;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Shop shop;

	public int getEmployee_Id() {
		return Employee_Id;
	}

	public void setEmployee_Id(int employee_Id) {
		Employee_Id = employee_Id;
	}

	public String getEmployee_Name() {
		return Employee_Name;
	}

	public void setEmployee_Name(String employee_Name) {
		Employee_Name = employee_Name;
	}

	public String getEmployee_Role() {
		return Employee_Role;
	}

	public void setEmployee_Role(String employee_Role) {
		Employee_Role = employee_Role;
	}

	public String getEmployee_Shift() {
		return Employee_Shift;
	}

	public void setEmployee_Shift(String employee_Shift) {
		Employee_Shift = employee_Shift;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "Employee [Employee_Id=" + Employee_Id + ", Employee_Name=" + Employee_Name + ", Employee_Role="
				+ Employee_Role + ", Employee_Shift=" + Employee_Shift + ", shop=" + shop + "]";
	}
	


}
