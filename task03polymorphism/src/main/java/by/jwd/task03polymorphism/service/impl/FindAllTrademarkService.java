package by.jwd.task03polymorphism.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.ServiceException;
import by.jwd.task03polymorphism.service.Validation;

public class FindAllTrademarkService {

	Validation validation = new Validation();

	public List<String> findAllTrademark(VanOfCoffee van) throws ServiceException {

		if (!validation.isValid(van)) {
			throw new ServiceException();
		}

		List<String> listOfTrademark = new ArrayList<>();
		String trademark;

		for (int i = 1; i < van.getAssortment().size(); i++) {
			trademark = van.getItemOfCoffee(0).getCoffee().getTrademark();
			if (!(listOfTrademark.contains(trademark))) {
				listOfTrademark.add(trademark);
			}
		}
		return listOfTrademark;
	}
}