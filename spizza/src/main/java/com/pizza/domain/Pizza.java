package com.pizza.domain;

import java.io.Serializable;

public class Pizza implements Serializable{

	private static final long serialVersionUID = 1L;

	private String size;
	
	private String[] toppings;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String[] getToppings() {
		return toppings;
	}

	public void setToppings(String[] toppings) {
		this.toppings = toppings;
	}
	
}
