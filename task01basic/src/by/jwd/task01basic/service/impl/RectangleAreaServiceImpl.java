package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.service.RectangleService;

/*7 linear task: the width of rectangle is half the length. Find the area of a rectangle*/

public class RectangleAreaServiceImpl implements RectangleService {
	/**
	 * Ñalculate the area of the rectangle
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param rectangle (Rectangle rectangle)
	 * @return double result of calculation
	 */

	@Override
	public double doCalculation(Rectangle rectangle) throws ServiceException {

		try {
			// validation
			if (rectangle.getLength() <= 0 || rectangle.getWidth() <= 0) {
				throw new IllegalArgumentException();
			}
			return rectangle.getLength() * rectangle.getWidth();

		} catch (IllegalArgumentException e) {
			throw new ServiceException();
		}
	}
}