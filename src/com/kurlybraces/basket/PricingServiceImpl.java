package com.kurlybraces.basket;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.kurlybraces.items.FruitType;

public class PricingServiceImpl implements PricingService {

	private Map<FruitType, Double> prices = new HashMap<>();

	private String PRICE_FILE = System.getProperty("PRICE_FILE");

	public PricingServiceImpl() {
		initPrices();
	}

	private void initPrices() {
		Arrays.asList(FruitType.values()).stream().forEach(f -> prices.put(f, getPriceFromFile(f)));
	}

	private double getPriceFromFile(FruitType f) {
		try {
			Path absolutePath = null;
			if (PRICE_FILE != null) {
				absolutePath = Paths.get(PRICE_FILE);
			} else {
				absolutePath = Paths.get(ClassLoader.getSystemResource("Prices.txt").toURI()).toAbsolutePath();
			}
			double fruitPrice = Files.lines(absolutePath).filter(s -> s.startsWith(f.name())).findAny().map(s -> {
				String[] arr = s.split("\\s");
				return Double.valueOf(arr[arr.length - 1]);
			}).orElseThrow(() -> new IllegalArgumentException("Price not found for " + f.name()));
			return fruitPrice;
		} catch (IOException | URISyntaxException e) {
			throw new IllegalArgumentException("Prices file not readable.");
		}
	}

	@Override
	public Double getPrice(FruitType fruitType) {
		return prices.get(fruitType);
	}
}
