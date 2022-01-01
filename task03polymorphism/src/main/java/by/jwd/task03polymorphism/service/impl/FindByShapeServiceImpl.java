package by.jwd.task03polymorphism.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.jwd.task03polymorphism.entity.InstantCoffee;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.FindByParameterService;
import by.jwd.task03polymorphism.service.ServiceException;
import by.jwd.task03polymorphism.service.Validation;

/**
 * Find coffee item by shape of instant coffee among assortment loaded in the van
 * 
 * @author evlashkina
 * @version 1
 * @param shape, van
 * @return List<ItemOfCoffee>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */
public class FindByShapeServiceImpl implements FindByParameterService<String> {

	Validation validation = new Validation();

	@Override
	public List<ItemOfCoffee> find(String shape, VanOfCoffee van) throws ServiceException {

		if (!validation.isValid(van)) {
			throw new ServiceException();
		}
		List<ItemOfCoffee> findedItem = new ArrayList<>();

		for (int i = 0; i < van.getAssortment().size(); i++) {

			if (van.getItemOfCoffee(i).getCoffee().getTitle().equals("растворимый")
					&& ((InstantCoffee) van.getItemOfCoffee(i).getCoffee()).getShape().equals(shape)) {
				findedItem.add(van.getItemOfCoffee(i));
			}
		}

		return findedItem;
	}

}