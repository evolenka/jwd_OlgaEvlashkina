package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticIntegerService;

/*33 loops task: find max digit of the given natural number.*/

public class MaxDigitOfNumberServiceImpl implements ArithmeticIntegerService {

	/**
	 * Find max digit of the given natural number.
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param numberData (given natural number)
	 * @return int digit
	 */

	@Override
	public int calculate(NumberData<Integer> numberData) throws ServiceException {
		try {
			if (numberData.getNumberData().get(0) <= 0) {
				throw new IllegalArgumentException();
			}
			int a = numberData.getNumberData().get(0);

			int maxDigit = 0;

			while (a > 0) {
				int temp = a % 10;
				if (temp > maxDigit) {
					maxDigit = temp;
				}
				a = a / 10;
			}
			return maxDigit;
			
		} catch (IllegalArgumentException e) {
			throw new ServiceException();
		}
	}
}