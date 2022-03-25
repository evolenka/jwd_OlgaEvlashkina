package by.jwd.task04repository.service;

import by.jwd.task04repository.entity.ITwoDShape;

/**
 * Provides method to make logic operations over the entity <T extends
 * ITwoDShape>
 * 
 * @author Evlashkina
 * @param T
 * @return boolean
 */

public interface TwoDShapeLogic<T extends ITwoDShape> {

	public boolean isTrue(T entity) throws ServiceException;
}
