package by.jwd.task05thread.service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.dao.DaoException;
import by.jwd.task05thread.dao.DaoFactory;
import by.jwd.task05thread.entity.Array;

public class ArrayCreator {

	private final DaoFactory daofactory = DaoFactory.getInstance();

	static Logger logger = LogManager.getLogger(ArrayCreator.class);

	/**
	 * Multithreading creating of array
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param fileName
	 * @return <T extends Number>
	 * @exception ServiceException
	 * @throws ServiceException if the file not found, invalid data in file, thread
	 *                          has been interrupted
	 * @see ArrayCreatorThread.class
	 */

	@SuppressWarnings("unchecked") // unchecked cast from Array <Double> to Array <T>
	public <T extends Number> Array<T> createArrayFromFile(String fileName) throws ServiceException {

		Array<T> array = null;

		int numberOfThreads = Runtime.getRuntime().availableProcessors();

		try {
			List<String> param = daofactory.getReader().readDataFromFile(fileName);// read param for array from file

			if (param != null) {
				DataParser parser = DataParser.getInstance();
				String[] parsedParam = parser.parse(param, 0);

				ConcurrentHashMap<Integer, Double> paramHashMap = new ConcurrentHashMap<>();

				for (int i = 0; i < parsedParam.length; i++) {
					paramHashMap.put(i, Double.valueOf(parsedParam[i]));
				}

				Double[] arr = new Double[paramHashMap.size()];

				array = (Array<T>) new Array<>(arr);// unchecked cast from Array <Double> to Array <T>

				// calculate quantity of elements which each thread should put into the array
				int quantity = paramHashMap.size() / numberOfThreads;

				// creating and starting threads
				for (int i = 0; i <= numberOfThreads; i++) {

					new ArrayCreatorThread<>("ThreadArrayCreator " + i, paramHashMap, array, quantity).start();
					TimeUnit.MILLISECONDS.sleep(50);
				}

				TimeUnit.SECONDS.sleep(2);
				logger.debug("hashmap {}", paramHashMap);

				// check whether all elements have been put into the array,
				// create additional thread, if not
				if (!paramHashMap.isEmpty()) {
					quantity = paramHashMap.size();
					ArrayCreatorThread<T> extraThread = new ArrayCreatorThread<>("AdditionalThreadArrayCreator ",
							paramHashMap, array, quantity);
					extraThread.start();
					extraThread.join();
				}
			}
		} catch (InterruptedException | NumberFormatException | DaoException e) {
			Thread.currentThread().interrupt();
			logger.error("thread has been interrupted");
			throw new ServiceException();
		}
		logger.debug("array has been created: {}", Thread.currentThread().getName());
		logger.debug(array);
		return array;
	}
}