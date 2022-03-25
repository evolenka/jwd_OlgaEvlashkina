package by.jwd.task04repository.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task04repository.entity.Point;

/**
 * Check whether two points are on the same line or not. In first case it is
 * impossible to make ellipse through these points, otherwise the ellipse can be
 * created
 * 
 * @author Evlashkina
 * @param firstPoint, secondPoint
 * @return false - in case two points are on the same line, true - otherwise
 */

public class CheckPointsToMakeEllipse {

	static Logger logger = LogManager.getLogger(CheckPointsToMakeEllipse.class);

	public boolean isTrue(Point firstPoint, Point secondPoint) {
		return !(firstPoint.getX() == secondPoint.getX() || firstPoint.getY() == secondPoint.getY());
	}
}