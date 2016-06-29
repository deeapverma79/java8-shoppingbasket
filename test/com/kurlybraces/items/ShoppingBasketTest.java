package com.kurlybraces.items;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kurlybraces.basket.ShoppingBasket;

public class ShoppingBasketTest {

	@Test
	public void testEmpty() {
		 ShoppingBasket shoppingBasket = new ShoppingBasket();
		 assertTrue(shoppingBasket.getContents().isEmpty());
	}

	@Test
	public void testAdd() {
		 ShoppingBasket shoppingBasket = new ShoppingBasket();
		 shoppingBasket.add(new Fruit(FruitType.BANANA));
		 assertEquals(shoppingBasket.getContents().size(), 1);
		 assertTrue(shoppingBasket.getContents().get(0).getFruitType().equals(FruitType.BANANA));
	}
	
	@Test
	public void testAddMore() {
		 ShoppingBasket shoppingBasket = new ShoppingBasket();
		 shoppingBasket.add(FruitType.ORANGE, 5);
		 assertEquals(shoppingBasket.getContents().size(), 5);
		 assertTrue(shoppingBasket.getContents().get(0).getFruitType().equals(FruitType.ORANGE));
	}
} 