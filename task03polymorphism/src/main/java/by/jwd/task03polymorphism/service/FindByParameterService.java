package by.jwd.task03polymorphism.service;

import java.util.List;

import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanOfCoffee;


public interface FindByParameterService <T>{

	public List <ItemOfCoffee> find(T parameter, VanOfCoffee van) throws ServiceException;
}
