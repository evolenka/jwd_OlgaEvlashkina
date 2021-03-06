package by.jwd.task02array.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;
import by.jwd.task02array.service.ArraySortingService;
import by.jwd.task02array.service.ServiceException;

/**
 * Shaker sorting of array
 * 
 * @author evlashkina
 * @version 1
 * @param array
 * @return <T extends Comparable<T>> Array<T>Arrray <T>
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data
 */

/*
 * обменная сортировка «Шейкер-сортировка» обрабатываем массив сначала слева
 * направо, перемещая наибольший элемент в конец массива, а затем справа налево,
 * перемещая наименьший элемент в начало массива
 */

public class ShakerSortImpl implements ArraySortingService {

	static Logger logger = LogManager.getLogger(ShakerSortImpl.class);

	@Override
	public <T extends Comparable<T>> Array<T> sortArray(Array<T> array) throws ServiceException {

		try {

			/*
			 * переменные, которые разграничивает отсортированную и неотсортированную часть
			 * массива слева и справа соответсвенно
			 * 
			 */
			int leftBounder = 0;
			int rightBounder = array.getLength() - 1;

			/*
			 * переменные, которые запоминают индексы последнего обмена при движении справа
			 * налево и слева направо соответственно
			 */

			int indexLastSwap = array.getLength() - 1;

			/*
			 * внешний цикл: выполняем, пока левый и правый ограничители отсортированной и
			 * неотсортированной части не встретятся, т.е. массив не станет отсортированным
			 */

			while (leftBounder < rightBounder) {
				/*
				 * цикл для движения слева направо, по его завершении максимальный элемент
				 * оказывается справа
				 */

				for (int i = leftBounder; i < rightBounder; i++) {
					if (array.getElement(i).compareTo(array.getElement(i + 1)) > 0) {
						swap(array, i, i + 1);
						indexLastSwap = i;
					}
				}
				/*
				 * переходим к последнему элементу неотсортированной части, чтобы начать с него
				 * движение справа налево
				 */
				rightBounder = indexLastSwap;

				/*
				 * цикл для движения справа налево, по его завершении минимальный элемент
				 * оказывается слева
				 */

				for (int i = rightBounder; i > leftBounder; i--) {
					if (array.getElement(i).compareTo(array.getElement(i - 1)) < 0) {
						swap(array, i, i - 1);
						indexLastSwap = i;
					}
				}
				/*
				 * переходим к первому элементу неотсортированной части, чтобы начать от него
				 * движение слева направо
				 */
				leftBounder = indexLastSwap;
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