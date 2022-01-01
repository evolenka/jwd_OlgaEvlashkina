package by.jwd.task02array.service.impl;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;
import by.jwd.task02array.service.ArraySortingService;
import by.jwd.task02array.service.ServiceException;

/**
 * Insertion sorting of array
 * 
 * @author evlashkina
 * @version 1
 * @param array
 * @return Arrray <Integer>
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data
 */

public class InsertionSortImpl implements ArraySortingService<Integer> {

	@Override
	public Array<Integer> sortArray(Array<Integer> array) throws ServiceException {
		/*
		 * внешний цикл: проходимся по каждому элементу, начиная со второго (j =1) и
		 * сравниваем его с предыдущим (слева), значение элемента, которому ищем место
		 * (a [j]) запоминаем в переменной temp
		 */
		try {
			for (int j = 1; j < array.getLength(); j++) {

				int i = j - 1;

				int temp = array.getElement(j);
				/*
				 * внутренний цикл идем влево пока не встретим элемент,который меньше либо пока
				 * не дойдем до начала каждый раз сдвигаем встречающийся (больший элемент)
				 * вправо
				 */
				while (i >= 0 && (temp < array.getElement(i))) {
					array.setElement((i + 1), array.getElement(i));
					i--;
				}
				/*
				 * при выходе из внутреннего цикла (когда место вставки для элемента j найдено)
				 * либо сразу (если элемент уже на месте) ставим его на нужное место
				 * (присваиваем значение) temp элементу, стоящему на найденном месте
				 */
				array.setElement((i + 1), temp);

			}
			return array;
		} catch (ArrayException e) {
			throw new ServiceException();
		}
	}
}