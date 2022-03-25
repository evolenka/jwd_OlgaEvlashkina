package by.jwd.task03polymorphism.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03polymorphism.entity.InstantCoffee;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.Title;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.FindByParameterService;
import by.jwd.task03polymorphism.service.ServiceException;
import by.jwd.task03polymorphism.service.Validation;

/**
 * Find coffee item by shape of instant coffee among assortment loaded in the
 * van
 * 
 * @author evlashkina
 * @version 1
 * @param shape, van
 * @return List<ItemOfCoffee>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */
public class FindByShapeServiceImpl implements FindByParameterService<String> {

	static Logger logger = LogManager.getLogger(FindByShapeServiceImpl.class);

	Validation validation = new Validation();
	
	@Override
	public List<ItemOfCoffee> find(String shape, VanOfCoffee van) throws ServiceException {

		if (!validation.isValid(van)) {
			throw new ServiceException();
		}
		List<ItemOfCoffee> findedItem = new ArrayList<>();

		logger.debug("start find cycle");
		for (int i = 0; i < van.getAssortment().size(); i++) {

			if (van.getItemOfCoffee(i).getCoffee().getTitle().equals(Title.INSTANT)
					&& ((InstantCoffee) van.getItemOfCoffee(i).getCoffee()).getShape().equals(shape)) {

				logger.debug("find item");
				findedItem.add(van.getItemOfCoffee(i));
			}
		}
		logger.debug("end find cycle");
		return findedItem;
	}

}