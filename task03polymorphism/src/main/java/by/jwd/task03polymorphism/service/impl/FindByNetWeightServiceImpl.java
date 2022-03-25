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
 * Find coffee item by range of net weight among assortment loaded in the van
 * 
 * @author evlashkina
 * @version 1
 * @param netWeight, van
 * @return List<ItemOfCoffee>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */

public class FindByNetWeightServiceImpl implements FindByParameterService<Integer[]> {

	static Logger logger = LogManager.getLogger(FindByNetWeightServiceImpl.class);

	Validation validation = new Validation();

	@Override
	public List<ItemOfCoffee> find(Integer[] netWeight, VanOfCoffee van) throws ServiceException {

		List<ItemOfCoffee> findedItem = new ArrayList<>();

		if (!validation.isValid(van)) {
			throw new ServiceException();
		}
		logger.debug("start initiation of min and max");

		int netWeightMin = netWeight[0];
		int netWeightMax = netWeight[1];

		logger.debug("end initiation of min and max");

		int itemNetWeight;

		logger.debug("start find cycle");
		for (int i = 0; i < van.getAssortment().size(); i++) {
			itemNetWeight = van.getItemOfCoffee(i).getCoffee().getNetWeight();

			if (itemNetWeight <= netWeightMax && itemNetWeight >= netWeightMin) {

				logger.debug("find item");
				findedItem.add(van.getItemOfCoffee(i));
			}
		}
		logger.debug("end find cycle");
		return findedItem;
	}
}