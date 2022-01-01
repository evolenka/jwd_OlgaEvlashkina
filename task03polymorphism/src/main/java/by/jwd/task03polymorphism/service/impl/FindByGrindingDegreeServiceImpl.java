package by.jwd.task03polymorphism.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.jwd.task03polymorphism.entity.GroundCoffee;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.FindByParameterService;
import by.jwd.task03polymorphism.service.ServiceException;
import by.jwd.task03polymorphism.service.Validation;

/**
 * Find coffee item by grinding degree of ground coffee among assortment loaded
 * in the van
 * 
 * @author evlashkina
 * @version 1
 * @param grindingDegree, van
 * @return List<ItemOfCoffee>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */

public class FindByGrindingDegreeServiceImpl implements FindByParameterService<String> {

	Validation validation = new Validation();

	@Override
	public List<ItemOfCoffee> find(String grindingDegree, VanOfCoffee van) throws ServiceException {

		List<ItemOfCoffee> findedItem = new ArrayList<>();

		if (!validation.isValid(van)) {
			throw new ServiceException();
		}

		for (int i = 0; i < van.getAssortment().size(); i++) {

			if (van.getItemOfCoffee(i).getCoffee().getTitle().equals("молотый")
					&& ((GroundCoffee) van.getItemOfCoffee(i).getCoffee()).getGrindingDegree().equals(grindingDegree)) {
				findedItem.add(van.getItemOfCoffee(i));
			}
		}

		return findedItem;
	}
}