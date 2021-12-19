package by.jwd.task02array.service;

import by.jwd.task02array.entity.Array;

public interface ArraySortingService <T> {
	
	/**
	 * Sorting of Array data
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param array
	 * @return arrray <T>
	 * @exception ServiceException
	 * @throws ServiceException if the file not found, invalid data in file
	 */

	public Array <T> sortArray(Array <T> array) throws ServiceException;
}