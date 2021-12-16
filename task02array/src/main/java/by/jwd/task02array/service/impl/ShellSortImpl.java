package by.jwd.task02array.service.impl;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;
import by.jwd.task02array.service.ArrayService;
import by.jwd.task02array.service.ServiceException;

public class ShellSortImpl implements ArrayService<Integer> {

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