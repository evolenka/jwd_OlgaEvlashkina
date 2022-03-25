package by.jwd.task01basic.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.ServiceException;
import by.jwd.task01basic.service.TriangleService;

/*19 linear task: find the area of the equilateral triangle, its height, the radius of the inscribed and circumscribed circles (part 1)*/

public class TriangleAreaServiceImpl implements TriangleService {

	/**
	 * Calculate the area of the equilateral triangle by the given side
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param triangle (given side of the triangle)
	 * @return double result of calculation
	 * @exception ServiceException
	 * @throws ServiceException if the argument is invalid for the calculation
	 */
	
	static Logger logger = LogManager.getLogger(TriangleAreaServiceImpl.class);

	@Override
	public double doCalculation(Triangle triangle) throws ServiceException {

		try {
			// validation
			if (triangle.getSide1() <= 0) {
				throw new IllegalArgumentException();
			}

			return (triangle.getSide1() * triangle.getSide1() * Math.sqrt(3)) / 4;

		} catch (IllegalArgumentException e) {
			logger.error("negative number (or = 0)");
			throw new ServiceException();
		}
	}
}