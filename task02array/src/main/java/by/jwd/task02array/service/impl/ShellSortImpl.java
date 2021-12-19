package by.jwd.task02array.service.impl;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;
import by.jwd.task02array.service.ArraySortingService;
import by.jwd.task02array.service.ServiceException;

/**
 * Shell sorting of array
 * 
 * @author evlashkina
 * @version 1
 * @param array
 * @return Arrray <Integer>
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data
 */

public class ShellSortImpl implements ArraySortingService<Integer> {

	@Override
	public Array<Integer> sortArray(Array<Integer> array) throws ServiceException {

		try {

			for (int h = array.getLength() / 2; h > 0; h /= 2) {

				for (int j = h; j < array.getLength(); j++) {

					int i = j - h;

					int temp = array.getElement(j);

					while (i >= 0 && temp < array.getElement(i)) {
						array.setElement((i + h), array.getElement(i));
						i = i - h;
					}

					array.setElement((i + h), temp);

				}
			}

			return array;
		} catch (ArrayException e) {
			throw new ServiceException(e);
		}
	}
}