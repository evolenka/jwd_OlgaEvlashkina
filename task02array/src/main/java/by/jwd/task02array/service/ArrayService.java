package by.jwd.task02array.service;

import by.jwd.task02array.entity.Array;

public interface ArrayService<T> {

	public Array<T> sortArray(Array <T> array) throws ServiceException;
}