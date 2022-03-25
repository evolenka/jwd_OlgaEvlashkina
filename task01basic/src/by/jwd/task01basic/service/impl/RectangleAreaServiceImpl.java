package by.jwd.task01basic.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.service.RectangleService;
import by.jwd.task01basic.service.ServiceException;

/*7 linear task: the width of rectangle is half the length. Find the area of a rectangle*/

public class RectangleAreaServiceImpl implements RectangleService {
	/**
	 * Ñalculate the area of the rectangle
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param rectangle (Rectangle rectangle)
	 * @return double result of calculation
	 * @exception ServiceException
	 * @throws ServiceException if the argument is invalid for the calculation
	 */
	static Logger logger = LogManager.getLogger(RectangleAreaServiceImpl.class);
	
	@Override
	public double doCalculation(Rectangle rectangle) throws ServiceException {

		try {
			// validation
			if (rectangle.getLength() <= 0 || rectangle.getWidth() <= 0) {
				throw new IllegalArgumentException();
			}
			return rectangle.getLength() * rectangle.getWidth();

		} catch (IllegalArgumentException e) {
			logger.error("negative number (or = 0)");
			throw new ServiceException();
		}
	}
}