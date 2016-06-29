package com.kurlybraces.items;

import static org.junit.Assert.*;

import org.junit.Test;

public class FruitTest {

	@Test
	public void createFruit() {
		 Fruit f = new Fruit(FruitType.APPLE);
		 assertEquals(FruitType.APPLE, f.getFruitType());
	}

}
