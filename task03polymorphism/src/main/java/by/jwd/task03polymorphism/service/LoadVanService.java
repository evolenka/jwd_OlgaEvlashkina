package by.jwd.task03polymorphism.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03polymorphism.dao.DaoException;
import by.jwd.task03polymorphism.dao.DaoFactory;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanException;
import by.jwd.task03polymorphism.entity.VanOfCoffee;

/**
 * Load van of coffee with the assortment for the amount not exceeding the given
 * amount and the van capacity
 * 
 * @author evlashkina
 * @version 1
 * @param capacity, amount, fileName
 * @return VanOfCoffee
 * @exception ServiceException
 * @throws ServiceException
 */

public class LoadVanService {

	static Logger logger = LogManager.getLogger(LoadVanService.class);

	private final DaoFactory daofactory = DaoFactory.getInstance();

	private final static int COEFFICIENT = 1000;// to cast capacity (in cubic metre) to the volume of packing (in
												// litres)

	public VanOfCoffee loadVan(int capacity, int amount, String fileName) throws ServiceException {

		List<ItemOfCoffee> vanAssortment = new ArrayList<>();
		List<ItemOfCoffee> allAssortment;

		/* arguments validation */
		try {
			if (amount < 0 || capacity < 0) {
				throw new IllegalArgumentException();
			}

			/* read data from file */
			logger.debug("start read from file");
			allAssortment = daofactory.getReader().readDataFromFile(fileName);
			logger.debug("end read from file");

			int temp = capacity * COEFFICIENT;

			/*
			 * load van with the assortment for the given amount and not exceeding the van
			 * capacity
			 */
			int i = 0;
			while (i < allAssortment.size() && (temp - (int) allAssortment.get(i).getPacking().getVolume()) > 0
					&& (amount - (int) allAssortment.get(i).getPrice()) > 0) {

				vanAssortment.add(allAssortment.get(i));
				logger.debug("add item to assortment");

				temp = temp - (int) vanAssortment.get(i).getPacking().getVolume();
				logger.debug("decreasing capacity");

				amount = amount - (int) vanAssortment.get(i).getPrice();
				logger.debug("decreasing amount");
				i++;
			}

			logger.debug("start creation of van object");
			VanOfCoffee van = new VanOfCoffee(capacity, vanAssortment);
			logger.debug("end creation of van object");

			return van;

		} catch (DaoException | VanException | IllegalArgumentException e) {
			throw new ServiceException();
		}
	}
}