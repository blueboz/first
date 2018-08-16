package com.pizza.domain;

import java.util.Arrays;
import java.util.List;

public enum Topping {
	芝士,
	肉松,
	培根,
	水果;
	
	public static List<Topping> asList(){
		Topping[] toppings = Topping.values();
		return Arrays.asList(toppings);
	}
}
