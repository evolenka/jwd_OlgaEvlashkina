package by.jwd.task04repository.service;

import by.jwd.task04repository.entity.Point;

/**
 * Validate wherther it is possible to make ellipse through two given points
 * @author Evlashkina
 * @param firstPoint, secondPoint
 * @return true - if it is possible to make ellipse, false - if not
 */
public class EllipseValidation {

	CheckPointsToMakeEllipse service = new CheckPointsToMakeEllipse();

	public boolean isValid(Point firstPoint, Point secondPoint) {
		return service.isTrue(firstPoint, secondPoint);
	}
}