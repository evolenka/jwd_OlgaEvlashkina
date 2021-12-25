package by.jwd.task03polymorphism.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.FindByParameterService;
import by.jwd.task03polymorphism.service.ServiceException;
import by.jwd.task03polymorphism.service.Validation;

public class FindByNetWeightServiceImpl implements FindByParameterService<Integer[]> {

	Validation validation = new Validation();

	@Override
	public List<ItemOfCoffee> find(Integer[] netWeight, VanOfCoffee van) throws ServiceException {

		List<ItemOfCoffee> findedItem = new ArrayList<>();

		if (!validation.isValid(van)) {
			throw new ServiceException();
		}

			int netWeightMin = netWeight[0];
			int netWeightMax = netWeight[1];

			int itemNetWeight;

			for (int i = 0; i < van.getAssortment().size(); i++) {
				itemNetWeight = van.getItemOfCoffee(i).getCoffee().getNetWeight();
				if (itemNetWeight <= netWeightMax && itemNetWeight >= netWeightMin) {
					findedItem.add(van.getItemOfCoffee(i));
				}
			}
		
		return findedItem;
	}
}