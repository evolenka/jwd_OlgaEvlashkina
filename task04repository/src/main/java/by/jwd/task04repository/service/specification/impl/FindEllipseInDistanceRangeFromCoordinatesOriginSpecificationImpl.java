package by.jwd.task04repository.service.specification.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task04repository.entity.IEllipse;
import by.jwd.task04repository.service.ServiceException;
import by.jwd.task04repository.service.specification.CompositeSpecification;

/**
 * Specifies whether the figure <T extends IEllipse> is in the range of distance
 * from the origin of coordinates
 * 
 * @author Evlashkina
 */
public class FindEllipseInDistanceRangeFromCoordinatesOriginSpecificationImpl<T extends IEllipse>
		extends CompositeSpecification<T> {

	static Logger logger = LogManager.getLogger(FindEllipseInDistanceRangeFromCoordinatesOriginSpecificationImpl.class);

	private double[] distance;

	public FindEllipseInDistanceRangeFromCoordinatesOriginSpecificationImpl(double[] distance) {
		this.distance = distance;
	}

	@Override
	public boolean isSpecified(T ellipse) throws ServiceException {
		if (distance.length == 2) {

			double a = Math.abs(ellipse.getFirstPoint().getX() - ellipse.getSecondPoint().getX());
			double b = Math.abs(ellipse.getFirstPoint().getY() - ellipse.getSecondPoint().getY());

			double oppositePointX;
			double oppositePointY;

			if (a > b) {
				logger.debug(
						"firstPoint of ellipse is the right point of the circumscribed rectangle, secondPoint is the upper point of the circumscribed rectangle");
				oppositePointX = ellipse.getFirstPoint().getX() - 2 * a;
				oppositePointY = ellipse.getSecondPoint().getY() - 2 * b;
			} else {
				logger.debug(
						"firstPoint of ellipse is the upper point of the circumscribed rectangle, the secondPoint - is the right point of circumscribed rectangle");
				oppositePointX = ellipse.getSecondPoint().getX() - 2 * a;
				oppositePointY = ellipse.getFirstPoint().getY() - 2 * b;
			}

			if (distance[0] != 0) {
				
				return Math.abs(ellipse.getFirstPoint().getX()) > distance[0]
						&& Math.abs(ellipse.getFirstPoint().getX()) < distance[1]
						&& Math.abs(ellipse.getFirstPoint().getY()) > distance[0]
						&& Math.abs(ellipse.getFirstPoint().getY()) < distance[1]
						&& Math.abs(ellipse.getSecondPoint().getX()) > distance[0]
						&& Math.abs(ellipse.getSecondPoint().getX()) < distance[1]
						&& Math.abs(ellipse.getSecondPoint().getY()) > distance[0]
						&& Math.abs(ellipse.getSecondPoint().getY()) < distance[1]
						&& Math.abs(oppositePointX) < distance[1] && Math.abs(oppositePointX) > distance[0]
						&& Math.abs(oppositePointY) < distance[1] && Math.abs(oppositePointY) > distance[0];

			} else {
				return Math.abs(ellipse.getFirstPoint().getX()) < distance[1]

						&& Math.abs(ellipse.getFirstPoint().getY()) < distance[1]
						&& Math.abs(ellipse.getSecondPoint().getX()) < distance[1]
						&& Math.abs(ellipse.getSecondPoint().getY()) < distance[1]
						&& Math.abs(oppositePointX) < distance[1] && Math.abs(oppositePointY) < distance[1];

			}
		} else {
			throw new ServiceException("invalid arguments");
		}

	}
}