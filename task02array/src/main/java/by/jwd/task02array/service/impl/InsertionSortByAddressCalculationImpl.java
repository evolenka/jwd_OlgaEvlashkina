package by.jwd.task02array.service.impl;

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
 * @return Arrray <Integer>
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data
 */
public class InsertionSortByAddressCalculationImpl implements ArraySortingService<Integer> {

	static final int SIZE = 10;

	@Override
	public Array<Integer> sortArray(Array<Integer> array) throws ServiceException {

		Array<Integer> result = array;

		/* создаем массив связанных списков из 10 списков */
		MyLinkedList[] lists = new MyLinkedList[SIZE];
		for (int i = 0; i < SIZE; i++) {
			lists[i] = new MyLinkedList();
		}

		/*
		 * вычисляем адрес для каждого элемента списка по формуле, затем помещаем
		 * элемент по адресу, который представляет собой порядковый номер списка при
		 * вставке элемента в список используем сортировку (метод вставки с сортировкой
		 * описан в классе MyLinkedList)
		 */
		try {
			int address;
			int max = findMax(array);

			for (int i = 0; i < array.getLength(); i++) {
				int value = array.getElement(i);
				if (max != 0) {
					address = (int) (value * 1.0) / max * (SIZE - 1);
				} else {
					address = (int) (value * 1.0) * (SIZE - 1);
				}
				address = address < 0 ? 0 : address;
				lists[address].insert(value);
			}

			/*
			 * вносим отсортированные значения из списков обратно в массив (метод для
			 * вставки числа из списка в массив описан в классе MyLinkedList
			 */

			MyLinkedList.passToArray(array, lists);

			return result;

		} catch (ArrayException e) {
			throw new ServiceException();
		}
	}

	/* метод для поиска максимального элемента в массиве */
	public int findMax(Array<Integer> array) throws ServiceException {

		try {
			int max = array.getElement(0);
			for (int i = 0; i < array.getLength() - 1; i++) {
				if (array.getElement(i + 1) > max) {
					max = array.getElement(i + 1);
				}
			}
			return max;
		} catch (ArrayException e) {
			throw new ServiceException();
		}
	}
}