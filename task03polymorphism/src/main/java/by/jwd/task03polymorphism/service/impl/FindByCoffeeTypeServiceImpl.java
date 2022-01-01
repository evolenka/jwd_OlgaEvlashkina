package by.jwd.task03polymorphism.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.FindByParameterService;
import by.jwd.task03polymorphism.service.ServiceException;
import by.jwd.task03polymorphism.service.Validation;

/**
 * Find coffee item by type among assortment loaded in the van
 * 
 * @author evlashkina
 * @version 1
 * @param title, van
 * @return List<ItemOfCoffee>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */
public class FindByCoffeeTypeServiceImpl implements FindByParameterService<String> {

	Validation validation = new Validation();

	@Override
	public List<ItemOfCoffee> find(String title, VanOfCoffee van) throws ServiceException {

		List<ItemOfCoffee> findedItem = new ArrayList<>();

		if (!validation.isValid(van)) {
			throw new ServiceException();
		}

		for (int i = 0; i < van.getAssortment().size(); i++) {

			if (van.getItemOfCoffee(i).getCoffee().getTitle().equals(title)) {
				findedItem.add(van.getItemOfCoffee(i));
			}
		}
		 return findedItem;
	}
}