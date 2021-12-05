package by.jwd.task01basic.service;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.entity.Rectangle;

public interface RectangleLogicService {

	/**
	 * Logic operations with the rectangle
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param Rectangle rectangle, NumberData<Double> numberData
	 * @return boolean result
	 * @exception ServiceException
	 * @throws ServiceException if the argument is invalid (negative or 0)
	 */

	public boolean doLogic(Rectangle rectangle, NumberData<Double> numberData) throws ServiceException;

}
