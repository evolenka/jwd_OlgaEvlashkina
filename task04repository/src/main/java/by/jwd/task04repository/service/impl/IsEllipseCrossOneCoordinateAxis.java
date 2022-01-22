package by.jwd.task04repository.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.service.EllipseValidation;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.TwoDShapeLogic;

/**
 * Check wherther the entity <T extends IEllipse> crosses one coordinate axis or
 * more than one
 * 
 * @author Evlashkina
 * @param ellipse
 * @return boolean (true - in case ellipse crosses one axis, false - otherwise)
 */
public class IsEllipseCrossOneCoordinateAxis<T extends IEllipse> implements TwoDShapeLogic<T> {


	EllipseValidation validation = new EllipseValidation();

	public boolean isTrue(T ellipse) throws ServiceException {

		if (validation.isValid(ellipse.getFirstPoint(), ellipse.getSecondPoint())) {

			return false;//TODO
		} else {
			throw new ServiceException();
		}
	}
}