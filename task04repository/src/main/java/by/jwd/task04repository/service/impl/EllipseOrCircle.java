package by.jwd.task04repository.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.service.EllipseValidation;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.TwoDShapeLogic;

/**
 * Check whether figure is ellipse or circle
 * 
 * @author Evlashkina
 * @param ellipse
 * @return true - in case it is circle, false -in case it is ellipse
 */

public class EllipseOrCircle<T extends IEllipse> implements TwoDShapeLogic<T> {

	static Logger logger = LogManager.getLogger(EllipseOrCircle.class);

	EllipseValidation validation = new EllipseValidation();

	public boolean isTrue(T ellipse) throws ServiceException {

		if (validation.isValid(ellipse.getFirstPoint(), ellipse.getSecondPoint())) {

			return Math.abs(ellipse.getFirstPoint().getX() - ellipse.getSecondPoint().getX()) == Math
					.abs(ellipse.getFirstPoint().getY() - ellipse.getSecondPoint().getY());

		} else {
			throw new ServiceException();
		}
	}
}