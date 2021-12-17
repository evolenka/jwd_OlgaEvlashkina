package by.jwd.task02array.service;

import java.io.File;
import by.jwd.task02array.dao.DaoException;
import by.jwd.task02array.dao.DaoFactory;
import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;

public class ArrayCreator {

	private final DaoFactory daofactory = DaoFactory.getInstance();

	public Array<Integer> createArrayFromFile(File file) throws ServiceException {
		
		Array<Integer> array = null;
		
		try {
			String [] param = daofactory.getReader().readDataFromFile (file);
			
			if (param != null) {
				array = new Array<>(param.length);
				for (int i = 0; i < array.getLength(); i++) {
					array.setElement(i, Integer.parseInt(param[i]));
				}
			}
				return array;
		} catch (NumberFormatException | ArrayException|DaoException e) {
			throw new ServiceException();
		}
}
}