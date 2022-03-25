package by.jwd.task03polymorphism.service;

import java.util.Comparator;

import by.jwd.task03polymorphism.entity.ItemOfCoffee;

public class PriceComparator implements Comparator<ItemOfCoffee> {

	@Override
	public int compare(ItemOfCoffee item1, ItemOfCoffee item2) {
		return ((int) item1.getPrice() - (int) item2.getPrice());
	}
}
