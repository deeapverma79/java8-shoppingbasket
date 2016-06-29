package com.kurlybraces.basket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.kurlybraces.items.Fruit;
import com.kurlybraces.items.FruitType;

public class ShoppingBasket {
	
	List<Fruit>  fruits = new ArrayList<>();

	public List<Fruit> getContents() {
		return fruits;
	}

	public void add(Fruit fruit) {
		fruits.add(fruit);
	}
	
	public void add(FruitType fruitType , Integer quantity){
		fruits.addAll(Stream.generate(() -> new Fruit(fruitType)).limit(quantity).collect(Collectors.toList()));
	}

}
