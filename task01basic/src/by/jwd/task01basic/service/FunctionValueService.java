package by.jwd.task01basic.service;

import by.jwd.task01basic.entity.NumberData;

public interface FunctionValueService {

	/**
	 * Find the value of function
	 * @author evlashkina
	 * @version 1
	 * @param NumberData<Double> numberData (list of double numbers)
	 * @return NumberData<Double> (list of function values)
	 */

	public NumberData<Double> findFunctionValue(NumberData<Double> numberData);
}