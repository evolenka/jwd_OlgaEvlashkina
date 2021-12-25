package by.jwd.task03polymorphism.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.FindByParameterService;
import by.jwd.task03polymorphism.service.ServiceException;
import by.jwd.task03polymorphism.service.Validation;

public class FindByMaxPriceServiceImpl implements FindByParameterService<Double> {

	Validation validation = new Validation();

	@Override
	public List<ItemOfCoffee> find(Double price, VanOfCoffee van) throws ServiceException {

		List<ItemOfCoffee> findedItem = new ArrayList<>();

		if (!validation.isValid(van)) {
			throw new ServiceException();
		}

			for (int i = 0; i < van.getAssortment().size(); i++) {

				if (van.getItemOfCoffee(i).getPrice() <= price) {
					findedItem.add(van.getItemOfCoffee(i));
				}
			}
		

		return findedItem;
	}
}
