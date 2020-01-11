package com.deloitte.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="orderTable")
public class OrderPage {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orderId")
	private int id;
	@Column(name="custName")
	private String name;
	@Column(name="custAddr")
	private String addr;
	@Column(name="custMobile")
	private String mobile;	
	private String foods;
	private String quantity;

	public OrderPage() {
	}

	public OrderPage(int id, String name, String addr, String mobile, 
				 String foods, String quantity) {
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.mobile = mobile;
		this.foods = foods;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotEmpty(message="Customer Name is required")
	@Pattern(regexp="^[A-Z][A-Za-z]{2,40}$", 
	   message="Customer name should have only characters and first letter should be uppercase")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotEmpty(message="Customer Address is required")
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@NotEmpty(message="Mobile is required")
	@Pattern(regexp = "[7-9][0-9]{9}",
		message="Mobile should start with 7,8 or 9 and have 10 digits")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Pattern(regexp = "^(?:(?!Select).)*$",
			message="Select the food")
	public String getFoods() {
		return foods;
	}	

	public void setFoods(String foods) {
		this.foods = foods;
	}
		
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Athlete [id=" + id + ", name=" + name + ", address=" + addr
				+ ", mobile="+ mobile + "]"+ ", foods=" + foods 
				+ ", quantity=" + quantity + "]" ;
	}

	

}

