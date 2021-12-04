package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticDoubleService;

/* 19 loops task: there are given the number row and number e.
Find the sum of numbers, which absolute values equals to or more than number e
a = 1/2^n + 1/3^n*/

public class SumOfPositiveRowMemberServiceImpl implements ArithmeticDoubleService {

	/**
	 * Calculate the sum of row elements, which absolute values equals to or more
	 * than the given number e, given that row element a = 1/2^n + 1/3^n
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param numberData (given number e and the length of the row)
	 * @return double result of calculation
	 */

	@Override
	public double calculate(NumberData<Double> numberData) {

		double e;
		double n;
		double a;
		double sum = 0;

		e = numberData.getNumberData().get(0);
		n = numberData.getNumberData().get(1);

		for (int i = 1; i <= n; i++) {
			a = 1 / Math.pow(2, i) + 1 / Math.pow(3, i);
			if (Math.abs(a) >= e) {
				sum = +a;
			}
		}
		return sum;
	}
}