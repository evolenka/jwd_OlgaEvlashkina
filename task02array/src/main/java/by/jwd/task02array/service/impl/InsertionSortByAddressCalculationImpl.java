package by.jwd.task02array.service.impl;

import java.util.List;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;
import by.jwd.task02array.service.ArraySortingService;
import by.jwd.task02array.service.MyLinkedList;
import by.jwd.task02array.service.ServiceException;

/**
 * Insertion sorting by address calculation
 * 
 * @author evlashkina
 * @version 1
 * @param array
 * @return <T extends Comparable<T>> Array<T>
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data
 */
public class InsertionSortByAddressCalculationImpl implements ArraySortingService {

	static final int SIZE = 10;

	@Override
	public <T extends Comparable<T>> Array<T> sortArray(Array<T> array) throws ServiceException {

		Array<T> result = array;
		MyLinkedList<T> myLinkedList = new MyLinkedList<T>();

		/* создаем массив связанных списков из 10 списков */
		MyLinkedList <T>[]lists = new MyLinkedList[SIZE];
		for (int i = 0; i < SIZE; i++) {
			lists[i] = new MyLinkedList<>();
		}

		/*
		 * вычисляем адрес для каждого элемента списка по формуле, затем помещаем
		 * элемент по адресу, который представляет собой порядковый номер списка при
		 * вставке элемента в список используем сортировку (метод вставки с сортировкой
		 * описан в классе MyLinkedList)
		 */
		try {
			Integer address;
			Integer max = (Integer) findMax(array);

			for (int i = 0; i < array.getLength(); i++) {
				T value = array.getElement(i);
				if (max != 0) {
					address = (int) ((int) value * 1.0) / max * (SIZE - 1);
				} else {
					address = (int) ((int) value * 1.0) * (SIZE - 1);
				}
				address = address < 0 ? 0 : address;
				lists[address].insert(value);
			}

			/*
			 * вносим отсортированные значения из списков обратно в массив (метод для
			 * вставки числа из списка в массив описан в классе MyLinkedList
			 */

			myLinkedList.passToArray(array, lists);

			return result;

		} catch (ArrayException e) {
			throw new ServiceException();
		}
	}

	/* метод для поиска максимального элемента в массиве */
	public <T extends Comparable<T>> T findMax(Array<T> array) throws ServiceException {

		try {
			T max = array.getElement(0);
			for (int i = 0; i < array.getLength() - 1; i++) {
				if (array.getElement(i + 1).compareTo(max) > 0) {
					max = array.getElement(i + 1);
				}
			}
			return max;
		} catch (ArrayException e) {
			throw new ServiceException();
		}
	}
}