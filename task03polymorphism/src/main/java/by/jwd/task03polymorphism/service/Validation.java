package by.jwd.task03polymorphism.service;

import by.jwd.task03polymorphism.entity.VanOfCoffee;

public class Validation {

	public boolean isValid(VanOfCoffee van) throws ServiceException {

		boolean res = true;
		try {
			for (int i = 0; i < van.getAssortment().size(); i++) {

				if (van.getItemOfCoffee(i).getCoffee().getPricePerKg() < 0
						|| van.getItemOfCoffee(i).getCoffee().getNetWeight() < 0
						|| van.getItemOfCoffee(i).getPrice() < 0 || van.getItemOfCoffee(i).getGrossWeight() < 0
						|| van.getItemOfCoffee(i).getPacking().getVolume() < 0
						|| van.getItemOfCoffee(i).getPacking().getWeight() < 0
						|| van.getItemOfCoffee(i).getPacking().getPrice() < 0) {
					res = false;
					break;
				}
			}

			return res;
		} catch (NullPointerException e) {
			throw new ServiceException();
		}
	}
}