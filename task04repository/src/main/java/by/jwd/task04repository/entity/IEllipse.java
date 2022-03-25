package by.jwd.task04repository.entity;

import by.jwd.task04repository.service.ServiceException;

/**
 * Extends abstract interface ITwoDShape and provides methods for entity ellipse
 * with two fields being points of circumscribed rectangle
 * 
 * @author Evlashkina
 * 
 */

public interface IEllipse extends ITwoDShape {

	public Point getFirstPoint();

	public void setFirstPoint(Point firstPoint) throws ServiceException;

	public Point getSecondPoint();

	public void setSecondPoint(Point secondPoint) throws ServiceException;
}