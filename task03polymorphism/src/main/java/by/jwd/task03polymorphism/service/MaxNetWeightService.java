package by.jwd.task03polymorphism.service;

import by.jwd.task03polymorphism.entity.VanOfCoffee;

/**
 * Find max net weight of coffee item, method findMaxNetWeight(VanOfCoffee van) used in 
 * FindBySeveralParametersServiceimpl in case user chooses search by the range
 * of the net weight but inputs only min weight
 * 
 * @author evlashkina
 * @version 1
 * @param van
 * @return int number
 * @exception ServiceException
 * @throws ServiceException
 */

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
