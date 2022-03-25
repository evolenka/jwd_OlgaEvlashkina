package by.jwd.task01basic.service;

import by.jwd.task01basic.entity.Triangle;

public interface TriangleService {
	/**
	 * Calculations with the rectangle
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param triangle
	 * @return double result of calculation
	 * @exception ServiceException
	 * @throws ServiceException if the argument is invalid for the calculation
	 */

	public double doCalculation(Triangle triangle) throws ServiceException;
}