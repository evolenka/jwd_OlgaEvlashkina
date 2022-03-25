package by.jwd.task03polymorphism.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03polymorphism.dao.DaoException;
import by.jwd.task03polymorphism.dao.DaoFactory;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.NetWeightComparator;
import by.jwd.task03polymorphism.service.ServiceException;
import by.jwd.task03polymorphism.service.SortingService;
import by.jwd.task03polymorphism.service.Validation;

/**
 * Sorting coffee assortment in the van by net weight
 * 
 * @author evlashkina
 * @version 1
 * @param van
 * @return List<ItemOfCoffee>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */

public class SortingByNetWeightServiceImpl implements SortingService {
	
	static Logger logger = LogManager.getLogger(SortingByNetWeightServiceImpl.class);

	private final DaoFactory daofactory = DaoFactory.getInstance();

	Validation validation = new Validation();

	@Override
	public List<ItemOfCoffee> sort(VanOfCoffee van) throws ServiceException {

		if (!validation.isValid(van)) {
			throw new ServiceException();
		}

		List<ItemOfCoffee> sortedAssortment = van.getAssortment();
		
		logger.debug("start sort");
		Collections.sort(sortedAssortment, new NetWeightComparator());
		logger.debug("end sort");

		logger.debug("start write to json file");
		try {
			daofactory.getWriter().writeDataToJSONFile(sortedAssortment, "SortingByNetWeight.json");

		} catch (DaoException e) {
			throw new ServiceException();
		}
		logger.debug("end write to json file");
		return sortedAssortment;

	}
}