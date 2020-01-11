package com.deloitte.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	@Id
	private int foodId;
	private String foodName;
	private double price;
	private int quantity;
	
	public Menu() {
		
	}

	public Menu(int foodId, String foodName, double price, int quantity) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.price = price;
		this.quantity = quantity;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Menu [foodId=" + foodId + ", foodName=" + foodName + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
	
}
