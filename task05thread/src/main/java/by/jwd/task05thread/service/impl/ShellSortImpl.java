package by.jwd.task05thread.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.entity.Array;
import by.jwd.task05thread.entity.ArrayException;
import by.jwd.task05thread.service.ArraySortingService;
import by.jwd.task05thread.service.ServiceException;

/**
 * Shell sorting of array
 * 
 * @author evlashkina
 * @version 1
 * @param array
 * @return T extends Number & Comparable<T>>
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data
 */

public class ShellSortImpl implements ArraySortingService {

	static Logger logger = LogManager.getLogger(ShellSortImpl.class);

	@Override
	public <T extends Number & Comparable<T>> Array<T> sortArray(Array<T> array) throws ServiceException {

		try {

			for (int h = array.getLength() / 2; h > 0; h /= 2) {

				for (int j = h; j < array.getLength(); j++) {

					int i = j - h;

					T temp = array.getElement(j);

					while (i >= 0 && temp.compareTo(array.getElement(i)) < 0) {
						array.setElement((i + h), array.getElement(i));
						i = i - h;
					}

					array.setElement((i + h), temp);
				}
			}

		} catch (ArrayException e) {
			throw new ServiceException(e);
		}
		logger.debug("shell sorting has been finished");
		return array;
	}
}