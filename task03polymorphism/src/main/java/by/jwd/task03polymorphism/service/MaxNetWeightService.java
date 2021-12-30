package by.jwd.task03polymorphism.service;

import by.jwd.task03polymorphism.entity.VanOfCoffee;

public class MaxNetWeightService {

	Validation validation = new Validation();

	public int findMaxNetWeight(VanOfCoffee van) throws ServiceException {

		if (!validation.isValid(van)) {
			throw new ServiceException();
		}

		int max = van.getItemOfCoffee(0).getCoffee().getNetWeight();

		for (int i = 1; i < van.getAssortment().size(); i++) {

			if (van.getItemOfCoffee(i).getCoffee().getNetWeight() > max) {
				max = van.getItemOfCoffee(i).getCoffee().getNetWeight();
			}
		}
		return max;
	}
}
