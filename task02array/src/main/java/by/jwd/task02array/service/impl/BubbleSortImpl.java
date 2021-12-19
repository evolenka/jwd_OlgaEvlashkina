package by.jwd.task02array.service.impl;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;
import by.jwd.task02array.service.ArraySortingService;
import by.jwd.task02array.service.ServiceException;

/**
 * Bubble Sorting of array
 * 
 * @author evlashkina
 * @version 1
 * @param array
 * @return Arrray <Integer>
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data
 */

//сортируем массив по возрастанию обменами (сравниваем два соседних числа и делается перестановка,
//если второе число больше первого. Так продолжается до тех пор, пока все элементы не станут расположены
//в порядке возрастания. Подсчитываем при этом количество перестановок. 

//переменная quantity служит индикатором для того чтобы понимать нужна ли еще сортировка,
//или элементы уже стоят по возрастанию,
//если при прохождении внутреннего цикла не было сделано ни одной перестановки, переменная quantity
//будет равна 0 и цикл while будет завершен (для запуска цикла присваиваем начальное значение переменной = 1
//затем обнуляем его в цикле)

public class BubbleSortImpl implements ArraySortingService <Integer> {

	@Override
	public Array<Integer> sortArray(Array<Integer> array) throws ServiceException {

		try {
			int quantity = 1;

			// внешний цикл для запуска внутреннего цикла снова и снова, пока все элементы
			// не станут на свои места
			while (quantity > 0) {
				quantity = 0;

				// внутренний цикл для сравнения соседних элементов массива по порядку
				for (int i = 1; i < array.getLength(); i++) {

					if (array.getElement(i) < array.getElement(i - 1)) {
						swap(array, i, i - 1);
						quantity++;
					}
				}
			}

			return array;
		} catch (ArrayException e) {
			throw new ServiceException();
		}
	}

	/* вспомогательный метод для обмена элементов местами */
	public <T> void swap(Array<T> array, int i, int j) throws ServiceException {
		try {
			T temp = array.getElement(i);
			array.setElement(i, array.getElement(j));
			array.setElement(j, temp);
		} catch (ArrayException e) {
			throw new ServiceException();
		}
	}
}
