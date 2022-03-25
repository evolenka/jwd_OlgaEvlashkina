package by.jwd.task04repository.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.service.EllipseValidation;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.TwoDShapeCalculation;

public class EllipseSquareCalculationImpl<T extends IEllipse> implements TwoDShapeCalculation<T> {

	/**
	 * Calculate ellipse square
	 * 
	 * @author Evlashkina
	 * @param ellipse
	 * @return double
	 */

	static Logger logger = LogManager.getLogger(EllipseSquareCalculationImpl.class);

	EllipseValidation validation = new EllipseValidation();

	@Override
	public double calculate(T ellipse) throws ServiceException {

		double square;

		if (validation.isValid(ellipse.getFirstPoint(), ellipse.getSecondPoint())) {

			square = Math.PI * (Math.abs(ellipse.getFirstPoint().getX() - ellipse.getSecondPoint().getX()))
					* (Math.abs(ellipse.getFirstPoint().getY() - ellipse.getSecondPoint().getY()));
		} else {
			throw new ServiceException();
		}
		logger.debug("square is calculated successfully {}", square);
		return square;
	}
}
