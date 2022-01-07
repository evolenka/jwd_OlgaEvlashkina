package by.jwd.task03polymorphism.service;

import java.util.Comparator;

import by.jwd.task03polymorphism.entity.ItemOfCoffee;

public class NetWeightComparator implements Comparator<ItemOfCoffee> {

	@Override
	public int compare(ItemOfCoffee item1, ItemOfCoffee item2) {
		return (item1.getCoffee().getNetWeight() - item2.getCoffee().getNetWeight());
	}
}
