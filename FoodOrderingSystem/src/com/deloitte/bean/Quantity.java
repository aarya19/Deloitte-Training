package com.deloitte.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quantity")
public class Quantity {
	@Id
	private String quantity;

	public Quantity() {
	}

	public Quantity(String quantity) {
		this.quantity = quantity;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Quantity [Quantity=" + quantity + "]";
	}
	
}
