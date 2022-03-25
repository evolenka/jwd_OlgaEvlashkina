package by.jwd.task01basic.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.ServiceException;
import by.jwd.task01basic.service.TriangleService;

/*19 linear task: find the area of the equilateral triangle, its height, the radius of the inscribed and circumscribed circles (part 2)*/

public class TriangleHeightServiceImpl implements TriangleService {

	/**
	 * Calculate the heigth of the equilateral triangle by the given side
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param triangle (given side of the triangle)
	 * @return double result of calculation
	 * @exception ServiceException
	 * @throws ServiceException if the argument is invalid for the calculation
	 */
	
	static Logger logger = LogManager.getLogger(TriangleHeightServiceImpl.class);
	
	@Override
	public double doCalculation(Triangle triangle) throws ServiceException {
		
		try {
			// validation
			if (triangle.getSide1() <= 0) {
				throw new IllegalArgumentException();
			}

			return (Math.sqrt(3)) / 2 * triangle.getSide1();
			
		} catch (IllegalArgumentException e) {
			logger.error("negative number (or = 0)");
			throw new ServiceException();
		}
	}
}