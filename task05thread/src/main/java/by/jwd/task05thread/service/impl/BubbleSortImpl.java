package by.jwd.task05thread.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.entity.Array;
import by.jwd.task05thread.entity.ArrayException;
import by.jwd.task05thread.service.ArraySortingService;
import by.jwd.task05thread.service.ServiceException;

/**
 * Bubble Sorting of array
 * 
 * @author e vlashkina
 * @version 1
 * @param array
 * @return <T extends Number & Comparable <T>>
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data
 */

//сортируем массив по возрастанию обменами (сравниваем два соседних числа и делаем перестановку,
//если второе число больше первого. Продолжаем, пока все элементы не станут расположены
//в порядке возрастания. Подсчитываем при этом количество перестановок. 

//переменная quantity служит индикатором для того чтобы понимать нужна ли еще сортировка,
//или элементы уже стоят по возрастанию,
//если при прохождении внутреннего цикла не было сделано ни одной перестановки, переменная quantity
//будет равна 0 и цикл while будет завершен (для запуска цикла присваиваем начальное значение переменной = 1
//затем обнуляем его в цикле)

public class BubbleSortImpl implements ArraySortingService {

	static Logger logger = LogManager.getLogger(BubbleSortImpl.class);

	@Override
	public <T extends Number & Comparable<T>> Array<T> sortArray(Array<T> array) throws ServiceException {
		try {
			int quantity = 1;

			// внешний цикл для запуска внутреннего цикла снова и снова, пока все элементы
			// не станут на свои места
			while (quantity > 0) {
				quantity = 0;

				// внутренний цикл для сравнения соседних элементов массива по порядку
				for (int i = 1; i < array.getLength(); i++) {

					if (array.getElement(i).compareTo(array.getElement(i - 1)) < 0) {
						swap(array, i, i - 1);
						quantity++;
					}
				}
			}

		} catch (ArrayException e) {
			throw new ServiceException();
		}
		logger.debug("bubble sorting has been finished");
		return array;
	}

	/* вспомогательный метод для обмена элементов местами */
	public <T extends Number> void swap(Array<T> array, int i, int j) throws ServiceException {
		try {
			T temp = array.getElement(i);
			array.setElement(i, array.getElement(j));
			array.setElement(j, temp);
		} catch (ArrayException e) {
			throw new ServiceException();
		}
	}
}