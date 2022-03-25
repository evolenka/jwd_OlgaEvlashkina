package by.jwd.task04repository.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.service.EllipseValidation;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.TwoDShapeCalculation;

/**
 * Calculate ellipse perimeter
 * 
 * @author Evlashkina
 * @param ellipse
 * @return double
 */

public class EllipsePerimeterCalculationImpl<T extends IEllipse> implements TwoDShapeCalculation<T> {

	static Logger logger = LogManager.getLogger(EllipsePerimeterCalculationImpl.class);
	
	EllipseValidation validation = new EllipseValidation();

	@Override
	public double calculate(T ellipse) throws ServiceException {

		double perimeter;

		if (validation.isValid(ellipse.getFirstPoint(), ellipse.getSecondPoint())) {

			double square = new EllipseSquareCalculationImpl<T>().calculate(ellipse);

			double a = Math.abs(ellipse.getFirstPoint().getX() - ellipse.getSecondPoint().getX());

			double b = Math.abs(ellipse.getFirstPoint().getY() - ellipse.getSecondPoint().getY());

			perimeter = 4 * (square + (a - b) * (a - b)) / (a + b);

		} else {
			throw new ServiceException();
		}
		logger.debug("perimeter is calculated successfully {}", perimeter);
		return perimeter;
	}
}