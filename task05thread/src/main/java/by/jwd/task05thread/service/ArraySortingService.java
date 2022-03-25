package by.jwd.task05thread.service;

import by.jwd.task05thread.entity.Array;

public interface ArraySortingService {

	/**
	 * Sorting of Array data
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param <T>
	 * @param array
	 * @return <T extends Comparable<T>> Array<T>
	 * @exception ServiceException
	 * @throws ServiceException if the file not found, invalid data in file
	 */

	public <T extends Number & Comparable<T>> Array<T> sortArray(Array<T> array) throws ServiceException;
}