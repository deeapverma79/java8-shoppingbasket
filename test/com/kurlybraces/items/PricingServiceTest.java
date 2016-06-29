package com.kurlybraces.items;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.*;

import com.kurlybraces.basket.PricingService;
import com.kurlybraces.basket.PricingServiceImpl;
import com.kurlybraces.calculator.ShoppingCalculator;
import com.kurlybraces.calculator.ShoppingCalculatorImpl;

public class PricingServiceTest {

	@Test(expected = IllegalArgumentException.class)
	public void testPricesNotLoaded() {
		try {
			System.setProperty("PRICE_FILE", "C:/Users/Deepa/workspace-mars/Test/src/resources/missingPrices.txt");
			PricingService pricingService = new PricingServiceImpl();
		} finally {
			System.clearProperty("PRICE_FILE");
		}
	}

	@Test
	public void testPrices() {
		PricingService pricingService = new PricingServiceImpl();
		assertEquals(2.1, pricingService.getPrice(FruitType.BANANA), 0.000001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPriceFileError() {
		try {
			System.setProperty("PRICE_FILE", "C:/missingPrices.txt");
			PricingService pricingService = new PricingServiceImpl();
		} finally {
			System.clearProperty("PRICE_FILE");
		}
	}
}
