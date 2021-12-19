package by.jwd.task02array.service.impl;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;
import by.jwd.task02array.service.ArraySortingService;
import by.jwd.task02array.service.ServiceException;

/**
 * Selection sorting of array
 * 
 * @author evlashkina
 * @version 1
 * @param array
 * @return Arrray <Integer>
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data
 */

/*
 * сортировка посредством выбора (метод простого выбора) находим минимальное
 * значение элемента, меняем его местами с первым элементом далее находим
 * минимальное среди оставишихся элементов и ставим его на второе место и т.д.)
 */

public class SelectionSortImpl implements ArraySortingService<Integer> {

	@Override
	public Array<Integer> sortArray(Array<Integer> array) throws ServiceException {
		try {
			for (int i = 0; i < array.getLength(); i++) {

				int min = array.getElement(i);
				int indexMin = i;

				for (int j = i + 1; j < array.getLength(); j++) {
					if (array.getElement(j) < min) {
						min = array.getElement(j);
						indexMin = j;
					}
				}

				int temp = array.getElement(i);
				array.setElement(i, min);
				array.setElement(indexMin, temp);
			}

			return array;
		} catch (ArrayException e) {
			throw new ServiceException();
		}
	}
}