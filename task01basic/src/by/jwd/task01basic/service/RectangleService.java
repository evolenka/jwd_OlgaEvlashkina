package by.jwd.task01basic.service;

import by.jwd.task01basic.entity.Rectangle;

public interface RectangleService {
	
	/**
	 * Calculations with the rectangle 
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param Rectangle rectangle
	 * @return double result of calculation
	 * @exception ServiceException
	 * @throws ServiceException if the argument is invalid for the calculation
	 */

	public double doCalculation(Rectangle rectangle) throws ServiceException;
}