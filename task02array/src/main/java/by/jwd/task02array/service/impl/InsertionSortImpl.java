package by.jwd.task02array.service.impl;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;
import by.jwd.task02array.service.ArrayService;
import by.jwd.task02array.service.ServiceException;

public class InsertionSortImpl implements ArrayService<Integer> {

	@Override
	public Array<Integer> sortArray(Array<Integer> array) throws ServiceException {

		Array<Integer> result;

		Integer[] sortedArray = new Integer[array.getLength()];
		try {
			for (int i = 0; i < sortedArray.length; i++) {
				sortedArray[i] = array.getElement(i);
			}

			/*
			 * внешний цикл: проходимся по каждому элементу, начиная со второго (j =1) и
			 * сравниваем его с предыдущим (слева), значение элемента, которому ищем место
			 * (a [j]) запоминаем в переменной temp
			 */

			for (int j = 1; j < sortedArray.length; j++) {

				int i = j - 1;

				int temp = sortedArray[j];
				/*
				 * внутренний цикл идем влево пока не встретим элемент,который меньше либо пока
				 * не дойдем до начала каждый раз сдвигаем встречающийся (больший элемент)
				 * вправо
				 */
				while (i >= 0 && (temp < sortedArray[i])) {
					sortedArray[i + 1] = sortedArray[i];
					i--;
				}
				/*
				 * при выходе из внутреннего цикла (когда место вставки для элемента j найдено)
				 * либо сразу (если элемент уже на месте) ставим его на нужное место
				 * (присваиваем значение) temp элементу, стоящему на найденном месте
				 */
				sortedArray[i + 1] = temp;

			}

			result = new Array<Integer>(sortedArray);

			return result;
		} catch (ArrayException e) {
			throw new ServiceException();
		}
	}
}