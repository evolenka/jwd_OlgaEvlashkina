package by.jwd.task05thread.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.entity.Array;
import by.jwd.task05thread.entity.ArrayException;
import by.jwd.task05thread.service.ArraySortingService;
import by.jwd.task05thread.service.ServiceException;

/**
 * Selection sorting of array
 * 
 * @author evlashkina
 * @version 1
 * @param array
 * @return <T extends Number & Comparable<T>>
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data
 */

/*
 * сортировка посредством выбора (метод простого выбора) находим минимальное
 * значение элемента, меняем его местами с первым элементом далее находим
 * минимальное среди оставишихся элементов и ставим его на второе место и т.д.)
 */

public class SelectionSortImpl implements ArraySortingService {

	static Logger logger = LogManager.getLogger(SelectionSortImpl.class);

	@Override
	public <T extends Number & Comparable<T>> Array<T> sortArray(Array<T> array) throws ServiceException {
		try {
			for (int i = 0; i < array.getLength(); i++) {

				T min = array.getElement(i);
				int indexMin = i;

				for (int j = i + 1; j < array.getLength(); j++) {
					if (array.getElement(j).compareTo(min) < 0) {
						min = array.getElement(j);
						indexMin = j;
					}
				}

				T temp = array.getElement(i);
				array.setElement(i, min);
				array.setElement(indexMin, temp);
			}
			logger.debug("selection sorting has been finished");
			return array;
		} catch (ArrayException e) {
			throw new ServiceException();
		}
	}
}