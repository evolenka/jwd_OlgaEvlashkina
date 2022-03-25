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

	static Logger logger = LogManager.getLogger(IsEllipseCrossOneCoordinateAxis.class);
	EllipseValidation validation = new EllipseValidation();

	public boolean isTrue(T ellipse) throws ServiceException {

		if (validation.isValid(ellipse.getFirstPoint(), ellipse.getSecondPoint())) {

			double a = Math.abs(ellipse.getFirstPoint().getX() - ellipse.getSecondPoint().getX());
			double b = Math.abs(ellipse.getFirstPoint().getY() - ellipse.getSecondPoint().getY());

			double oppositePointX;
			double oppositePointY;

			if (a > b) {
				logger.debug(
						"firstPoint of ellipse is the right point of the circumscribed rectangle, secondPoint is the upper point of the circumscribed rectangle");
				oppositePointX = ellipse.getFirstPoint().getX() - 2 * a;
				oppositePointY = ellipse.getSecondPoint().getY() - 2 * b;

				return ((ellipse.getFirstPoint().getX() > 0 && oppositePointX < 0)
						&& (ellipse.getSecondPoint().getY() > 0 && oppositePointY > 0)) ||

						((ellipse.getFirstPoint().getX() > 0 && oppositePointX > 0)
								&& (ellipse.getSecondPoint().getY() > 0 && oppositePointY < 0))
						||

						((ellipse.getFirstPoint().getX() < 0 && oppositePointX < 0)
								&& (ellipse.getSecondPoint().getY() > 0 && oppositePointY < 0))
						||

						((ellipse.getFirstPoint().getX() > 0 && oppositePointX < 0)
								&& (ellipse.getSecondPoint().getY() < 0 && oppositePointY < 0));
			} else {
				logger.debug(
						"firstPoint of ellipse is the upper point of the circumscribed rectangle, the secondPoint - is the right point of circumscribed rectangle");
				oppositePointX = ellipse.getSecondPoint().getX() - 2 * a;
				oppositePointY = ellipse.getFirstPoint().getY() - 2 * b;

				return ((ellipse.getFirstPoint().getY() > 0 && oppositePointY < 0)
						&& (ellipse.getSecondPoint().getX() > 0 && oppositePointX > 0)) ||

						((ellipse.getFirstPoint().getY() > 0 && oppositePointY > 0)
								&& (ellipse.getSecondPoint().getX() > 0 && oppositePointX < 0))
						||

						((ellipse.getFirstPoint().getY() < 0 && oppositePointY < 0)
								&& (ellipse.getSecondPoint().getX() > 0 && oppositePointX < 0))
						||

						((ellipse.getFirstPoint().getY() > 0 && oppositePointY < 0)
								&& (ellipse.getSecondPoint().getX() < 0 && oppositePointX < 0));
			}
		} else {
			throw new ServiceException();
		}
	}
}