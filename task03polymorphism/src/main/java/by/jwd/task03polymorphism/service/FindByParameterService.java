package by.jwd.task03polymorphism.service;

import java.util.List;

import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanOfCoffee;

/**
 * Find coffee items by parameter(s)
 * 
 * @author evlashkina
 * @version 1
 * @param parameter, van
 * @return List<ItemOfCoffee>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */

public interface FindByParameterService<T> {

	public List<ItemOfCoffee> find(T parameter, VanOfCoffee van) throws ServiceException;
}
