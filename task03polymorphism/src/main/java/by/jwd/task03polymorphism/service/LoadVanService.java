package by.jwd.task03polymorphism.service;

import java.util.ArrayList;
import java.util.List;

import by.jwd.task03polymorphism.dao.DaoException;
import by.jwd.task03polymorphism.dao.DaoFactory;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanException;
import by.jwd.task03polymorphism.entity.VanOfCoffee;

public class LoadVanService {

	private final DaoFactory daofactory = DaoFactory.getInstance();

	public VanOfCoffee loadVan(int amount, int capacity) throws ServiceException, VanException {

		List<ItemOfCoffee> vanAssortment = new ArrayList<>();
		List<ItemOfCoffee> allAssortment;
		

		try {

			allAssortment = daofactory.getReader().readDataFromFile();
			
			int i = 0; 
			int temp = capacity;
				while (temp > 0 && amount > 0 && i < allAssortment.size()) {

					vanAssortment.add(allAssortment.get(i));
					temp = temp - (int) vanAssortment.get(i).getPacking().getVolume();
					amount = amount - (int)vanAssortment.get(i).getPrice();
					i++;
				}
			
		
			VanOfCoffee van = new VanOfCoffee(capacity, vanAssortment);
			
			return van;

		} catch (DaoException  e) {
			throw new ServiceException();
		}
	}
}