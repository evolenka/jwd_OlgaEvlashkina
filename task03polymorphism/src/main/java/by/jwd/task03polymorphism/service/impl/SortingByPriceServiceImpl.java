package by.jwd.task03polymorphism.service.impl;

import java.util.Collections;
import java.util.List;

import by.jwd.task03polymorphism.dao.DaoException;
import by.jwd.task03polymorphism.dao.DaoFactory;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.PriceComparator;
import by.jwd.task03polymorphism.service.ServiceException;
import by.jwd.task03polymorphism.service.SortingService;
import by.jwd.task03polymorphism.service.Validation;

/**
 * Sorting coffee assortment in the van by price
 * 
 * @author evlashkina
 * @version 1
 * @param van
 * @return List<ItemOfCoffee>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */
public class SortingByPriceServiceImpl implements SortingService {

	private final DaoFactory daofactory = DaoFactory.getInstance();

	Validation validation = new Validation();

	@Override
	public List<ItemOfCoffee> sort(VanOfCoffee van) throws ServiceException {

		if (!validation.isValid(van)) {
			throw new ServiceException();
		}

		List<ItemOfCoffee> sortedAssortment = van.getAssortment();

		Collections.sort(sortedAssortment, new PriceComparator());

		try {
			daofactory.getWriter().writeDataToJSONFile(sortedAssortment, "SortingByPrice.json");

		} catch (DaoException e) {
			throw new ServiceException();
		}

		return sortedAssortment;
	}
}
