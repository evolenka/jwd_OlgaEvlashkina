package by.jwd.task03polymorphism.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

	static Logger logger = LogManager.getLogger(FindByCoffeeTypeServiceImpl.class);

	Validation validation = new Validation();

	@Override
	public List<ItemOfCoffee> find(String title, VanOfCoffee van) throws ServiceException {

		List<ItemOfCoffee> findedItem = new ArrayList<>();

		if (!validation.isValid(van)) {
			throw new ServiceException();
		}
		
		logger.debug("start find cycle");
		
		for (int i = 0; i < van.getAssortment().size(); i++) {

			if (van.getItemOfCoffee(i).getCoffee().getTitle().equals(title)) {
				
				logger.debug("find item");
				findedItem.add(van.getItemOfCoffee(i));
			}
		}
		
		logger.debug("end find cycle");
		 return findedItem;
	}
}