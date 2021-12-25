package by.jwd.task03polymorphism.service;

import java.util.List;

import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanOfCoffee;

public interface SortingService {

	public List<ItemOfCoffee> sort(VanOfCoffee van) throws ServiceException;
}