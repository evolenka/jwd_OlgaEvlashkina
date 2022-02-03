package by.jwd.task05thread.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.dao.DaoException;
import by.jwd.task05thread.dao.DaoFactory;
import by.jwd.task05thread.entity.Array;

public class ArrayCreator {

	private final DaoFactory daofactory = DaoFactory.getInstance();

	static Logger logger = LogManager.getLogger(ArrayCreator.class);

	/**
	 * Creation of array from File
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param fileName
	 * @return
	 * @return <T extends Number> 
	 * @exception ServiceException
	 * @throws ServiceException if the file not found, invalid data in file
	 */

	@SuppressWarnings("unchecked") // unchecked cast from Array <Double> to Array <T>
	public <T extends Number> Array<T> createArrayFromFile(String fileName) throws ServiceException {

		Array<T> array = null;

		try {

			List<String> param = daofactory.getReader().readDataFromFile(fileName);
			
			DataParser parser = DataParser.getInstance();

			String[] parsedParam = parser.parse(param, 0);

			if (parsedParam != null) {
				Double[] arr = new Double[parsedParam.length];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = Double.valueOf(parsedParam[i]);
				}

				array = (Array<T>) new Array<>(arr);// unchecked cast from Array <Double> to Array <T>
			}
		} catch (NumberFormatException | DaoException e) {
			throw new ServiceException();
		}
		logger.debug("array has been created: {}", Thread.currentThread().getName());
		return array;
	}
}