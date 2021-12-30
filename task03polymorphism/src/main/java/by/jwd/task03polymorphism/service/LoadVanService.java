package by.jwd.task03polymorphism.service;

import java.util.ArrayList;
import java.util.List;

import by.jwd.task03polymorphism.dao.DaoException;
import by.jwd.task03polymorphism.dao.DaoFactory;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanException;
import by.jwd.task03polymorphism.entity.VanOfCoffee;

/**
 * Load van for given amount of coffee items and nit exceeding the van capacity
 * 
 * @author evlashkina
 * @version 1
 * @param capacity, amount, fileName
 * @return VanOfCoffee
 * @exception ServiceException
 * @throws ServiceException
 */

public class LoadVanService {

	private final DaoFactory daofactory = DaoFactory.getInstance();

	public VanOfCoffee loadVan(int capacity, int amount, String fileName) throws ServiceException {

		List<ItemOfCoffee> vanAssortment = new ArrayList<>();
		List<ItemOfCoffee> allAssortment;

		/* arguments validation */
		try {
			if (amount < 0 || capacity < 0) {
				throw new IllegalArgumentException();
			}

			/* read data from file */
			allAssortment = daofactory.getReader().readDataFromFile(fileName);

			final int COEFFICIENT = 1000;// capacity - in cubic metre, volume of packing - in litres
			int temp = capacity * COEFFICIENT;

			/*
			 * load van with the assortment for the given amount and not exceeding the van
			 * capacity
			 */
			int i = 0;
			while (i < allAssortment.size() && (temp - (int) allAssortment.get(i).getPacking().getVolume()) > 0
					&& (amount - (int) allAssortment.get(i).getPrice()) > 0) {

				vanAssortment.add(allAssortment.get(i));
				temp = temp - (int) vanAssortment.get(i).getPacking().getVolume();
				amount = amount - (int) vanAssortment.get(i).getPrice();
				i++;
			}

			VanOfCoffee van = new VanOfCoffee(capacity, vanAssortment);

			return van;

		} catch (DaoException | VanException |

				IllegalArgumentException e) {
			throw new ServiceException();
		}
	}
}