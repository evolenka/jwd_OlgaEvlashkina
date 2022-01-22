package by.jwd.task03polymorphism.service;

import by.jwd.task03polymorphism.entity.Coffee;
import by.jwd.task03polymorphism.entity.Packing;

public class GrossWeightCalculation {

	public int calculate (Coffee coffee, Packing packing) throws IllegalArgumentException {

		if (coffee.getNetWeight() > 0 || packing.getWeight() > 0) {
			return coffee.getNetWeight() + packing.getWeight();
		} else
			throw new IllegalArgumentException();
	}
}
