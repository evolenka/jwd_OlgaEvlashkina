package by.jwd.task03polymorphism.service;

import java.util.List;

import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanOfCoffee;

/**
 * Sorting coffee assortment
 * 
 * @author evlashkina
 * @version 1
 * @param van
 * @return List<ItemOfCoffee>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */
public interface SortingService {

	public List<ItemOfCoffee> sort(VanOfCoffee van) throws ServiceException;
}