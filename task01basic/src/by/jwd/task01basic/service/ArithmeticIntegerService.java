package by.jwd.task01basic.service;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.impl.ServiceException;

public interface ArithmeticIntegerService {

	public int calculate(NumberData<Integer> numberData) throws ServiceException;
}