package by.jwd.task03polymorphism.service;

import java.util.Comparator;

import by.jwd.task03polymorphism.entity.ItemOfCoffee;

public class PriceToNetWeightComparator implements Comparator<ItemOfCoffee> {

	@Override
	public int compare(ItemOfCoffee item1, ItemOfCoffee item2) {

		double ratio1 = item1.getPrice() *100 / item1.getCoffee().getNetWeight();
		double ratio2 = item2.getPrice() *100/ item2.getCoffee().getNetWeight();

		return ((int) ratio1 - (int) ratio2);
	}
}
