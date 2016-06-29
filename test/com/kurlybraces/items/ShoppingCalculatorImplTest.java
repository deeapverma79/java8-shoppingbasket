package com.kurlybraces.items;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.kurlybraces.basket.PricingService;
import com.kurlybraces.basket.ShoppingBasket;
import com.kurlybraces.calculator.ShoppingCalculator;
import com.kurlybraces.calculator.ShoppingCalculatorImpl;

public class ShoppingCalculatorImplTest {

	@Test
	public void testCalculate() {
		ShoppingBasket shoppingBasket = mock(ShoppingBasket.class);
		PricingService pricingService = mock(PricingService.class);
		
		ShoppingCalculator shoppingCalculator = new ShoppingCalculatorImpl(pricingService);

		// Given a shoppingBasket
		List<Fruit> fruitList = Arrays.asList(new Fruit(FruitType.BANANA), new Fruit(FruitType.ORANGE));
		given(shoppingBasket.getContents()).willReturn(fruitList);
		given(pricingService.getPrice(FruitType.BANANA)).willReturn(2.1);
		given(pricingService.getPrice(FruitType.ORANGE)).willReturn(2.3);
		// when
		double value = shoppingCalculator.calculate(shoppingBasket);
		// then
		assertEquals(value, 4.4, 0.000001);
	}

	@Test
	public void testEmptyBasket() {
		ShoppingBasket shoppingBasket = mock(ShoppingBasket.class);
		PricingService pricingService = mock(PricingService.class);

		ShoppingCalculator shoppingCalculator = new ShoppingCalculatorImpl(pricingService);

		// Given a shoppingBasket
		List<Fruit> fruitList = Arrays.asList();
		given(shoppingBasket.getContents()).willReturn(fruitList);
		// when
		double value = shoppingCalculator.calculate(shoppingBasket);
		// then
		assertEquals(value, 0.0 , 0.0);
	}
	
}
