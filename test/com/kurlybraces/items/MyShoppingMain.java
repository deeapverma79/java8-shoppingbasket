package com.kurlybraces.items;

import com.kurlybraces.basket.PricingService;
import com.kurlybraces.basket.PricingServiceImpl;
import com.kurlybraces.basket.ShoppingBasket;
import com.kurlybraces.calculator.ShoppingCalculator;
import com.kurlybraces.calculator.ShoppingCalculatorImpl;
import com.kurlybraces.items.Fruit;
import com.kurlybraces.items.FruitType;

public class MyShoppingMain {

	public static void main(String[] args) {

		// I pick up an empty shopping basket
		ShoppingBasket shoppingBasket = new ShoppingBasket();

		// Add a Banana to my basket
		shoppingBasket.add(new Fruit(FruitType.BANANA)); //2.1

		// Add 5 Apples to my basket
		shoppingBasket.add(FruitType.APPLE, 5); //4.5

		// Add 2 Apples to my basket
		shoppingBasket.add(FruitType.ORANGE, 2); //1.3
		
		PricingService p = new PricingServiceImpl();
		// Bill my basket
		ShoppingCalculator valueCalculator = new ShoppingCalculatorImpl(p); 
		System.out.println(valueCalculator.calculate(shoppingBasket));	  
	}

}
