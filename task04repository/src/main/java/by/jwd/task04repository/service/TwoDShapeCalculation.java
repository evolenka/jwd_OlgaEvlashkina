package by.jwd.task04repository.service;

import by.jwd.task04repository.entity.ITwoDShape;

/**
 * Provides method to make calcuations over the entity <T extends ITwoDShape>
 * 
 * @author Evlashkina
 * @param T
 * @return double
 */

public interface TwoDShapeCalculation<T extends ITwoDShape> {

	public double calculate(T entity) throws ServiceException;
}