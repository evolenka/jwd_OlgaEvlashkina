package by.jwd.task03polymorphism.service;

import by.jwd.task03polymorphism.entity.Coffee;

public class TotalPriceCalculation {

	public double calculate(Coffee coffee) {

		if (coffee.getNetWeight() > 0 || coffee.getPricePerKg() >= 0) {
			return coffee.getPricePerKg() * coffee.getNetWeight() / 1000;
		} else
			throw new IllegalArgumentException();
	}
}
