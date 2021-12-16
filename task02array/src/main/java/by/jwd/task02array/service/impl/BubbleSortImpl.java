package by.jwd.task02array.service.impl;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;
import by.jwd.task02array.service.ArrayService;
import by.jwd.task02array.service.ServiceException;

//сортируем массив по возрастанию обменами (сравниваем два соседних числа и делается перестановка,
//если второе число больше первого. Так продолжается до тех пор, пока все элементы не станут расположены
//в порядке возрастания. Подсчитываем при этом количество перестановок. 

//переменная quantity служит индикатором для того чтобы понимать нужна ли еще сортировка,
//или элементы уже стоят по возрастанию,
//если при прохождении внутреннего цикла не было сделано ни одной перестановки, переменная quantity
//будет равна 0 и цикл while будет завершен (для запуска цикла присваиваем начальное значение переменной = 1
//затем обнуляем его в цикле)

public class BubbleSortImpl implements ArrayService<Integer> {

	@Override
	public Array<Integer> sortArray(Array<Integer> array) throws ServiceException {

		Array<Integer> result;

		Integer[] sortedArray = new Integer[array.getLength()];
		try {
			for (int i = 0; i < sortedArray.length; i++) {
				sortedArray[i] = array.getElement(i);
			}
	     } catch (ArrayException e) {
			throw new ServiceException();
		}

			int quantity = 1;

			// внешний цикл для запуска внутреннего цикла снова и снова, пока все элементы
			// не станут на свои места
			while (quantity > 0) {
				quantity = 0;

				// внутренний цикл для сравнения соседних элементов массива по порядку
				for (int i = 1; i < sortedArray.length; i++) {

					if (sortedArray[i] < sortedArray[i - 1]) {
						int temp = sortedArray[i];
						sortedArray[i] = sortedArray[i - 1];
						sortedArray[i - 1] = temp;
						quantity++;
					}
				}
			}

			result = new Array<>(sortedArray);
			return result;
		}
	}