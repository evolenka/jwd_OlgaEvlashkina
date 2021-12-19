package by.jwd.task02array.service;

import by.jwd.task02array.dao.DaoException;
import by.jwd.task02array.dao.DaoFactory;
import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;

public class ArrayCreator {

	private final DaoFactory daofactory = DaoFactory.getInstance();

	/**
	 * Creation of array from File
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param fileName
	 * @return arrray <Integer>
	 * @exception ServiceException
	 * @throws ServiceException if the file not found, invalid data in file
	 */

	public Array<Integer> createArrayFromFile(String fileName) throws ServiceException {

		Array<Integer> array = null;

		
		try {
			
			String[] param = daofactory.getReader().readDataFromFile(fileName);

			if (param != null) {

				Integer[] arr = new Integer[param.length];
				array = new Array<>(arr);

				for (int i = 0; i < array.getLength(); i++) {
					array.setElement(i, Integer.parseInt(param[i]));
				}
			}
			return array;
		} catch (NumberFormatException | ArrayException | DaoException e) {
			throw new ServiceException();
		}
	}
}