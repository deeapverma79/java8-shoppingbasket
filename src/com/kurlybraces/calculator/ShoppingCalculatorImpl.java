package com.kurlybraces.calculator;

import com.kurlybraces.basket.PricingService;
import com.kurlybraces.basket.ShoppingBasket;

public class ShoppingCalculatorImpl implements ShoppingCalculator {

	PricingService pricingService ;
	
	public ShoppingCalculatorImpl(PricingService pricingService) {
		this.pricingService = pricingService; 
	}
	
	@Override
	public double calculate(ShoppingBasket shoppingBasket) {
		return shoppingBasket.getContents().stream().mapToDouble(f->pricingService.getPrice(f.getFruitType())).sum();
	}
}
