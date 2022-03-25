package by.jwd.task05thread.service;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.dao.DaoException;
import by.jwd.task05thread.dao.DaoFactory;
import by.jwd.task05thread.entity.Matrix;

/**
 * Multithreading creating of matrix
 * 
 * @author evlashkina
 * @version 1
 * @param fileName, rowQuantity, columnQuantity
 * @return Matrix<T extends Number>
 * @exception ServiceException
 * @throws ServiceException if file not found, invalid arguments or invalid data
 *                          in file, thread has been interrupted
 */

public class MatrixCreator {

	static Logger logger = LogManager.getLogger(MatrixCreator.class);

	private final DaoFactory daofactory = DaoFactory.getInstance();

	@SuppressWarnings("unchecked") // unchecked cast from Matrix <Double> to Matrix <T>

	public <T extends Number> Matrix<T> createMatrixFromFile(String fileName, int rowQuantity, int columnQuantity)
			throws ServiceException {

		Matrix<T> matrix = null;

		// check arguments before creating of matrix
		try {
			if (rowQuantity <= 0 || columnQuantity <= 0) {
				throw new ServiceException();
			}

			int numberOfThreads = Runtime.getRuntime().availableProcessors();

			if (rowQuantity * columnQuantity <= numberOfThreads) {
				numberOfThreads = rowQuantity * columnQuantity;
				logger.debug(numberOfThreads);
			}

			CountDownLatch countDown = new CountDownLatch(numberOfThreads + 1);

			Double[][] m = new Double[rowQuantity][columnQuantity];

			matrix = (Matrix<T>) new Matrix<>(m);

			List<String> param = daofactory.getReader().readDataFromFile(fileName);// read param for matrix from file

			if (param != null) {

				DataParser parser = DataParser.getInstance();
				String[] parsedParam = parser.parse(param, 0);

				// calculate quantity of elements which each thread should put into the matrix
				int quantity = rowQuantity * columnQuantity / numberOfThreads;
				logger.debug("quantity{}", quantity);

				// create and start of threads
				for (int i = 0; i <= numberOfThreads; i++) {

					MatrixCreatorThread<T> t = new MatrixCreatorThread<>(countDown, parsedParam, matrix, i, quantity);
					t.setName("ThreadMatrixCreator " + i);
					t.start();
					TimeUnit.MILLISECONDS.sleep(500);
				}

				// wait until all threads have completed (the latch has counted down to zero),
				// or the specified waiting time elapses.

				boolean isSuccessfull = countDown.await(5, TimeUnit.SECONDS);
				logger.debug(isSuccessfull);

				/*
				 * in case not all threads have completed (specified awaiting time elapses, but
				 * latch does not equal to zero), create additional thread instead of
				 * interrupted thread
				 */

				if (!isSuccessfull) {
					int i = MatrixCreatorThread.getErrorIndex();
					MatrixCreatorThread<T> t = new MatrixCreatorThread<>(countDown, parsedParam, matrix, i, quantity);
					t.setName("AdditionalThreadMatrixCreator " + i);
					t.start();
					t.join();
				}
			}
		} catch (InterruptedException | NumberFormatException | DaoException e) {
			Thread.currentThread().interrupt();
			logger.error("thread has been interrupted {}", Thread.currentThread().getName());
			throw new ServiceException();
		}
		logger.debug("matrix has been created");
		return matrix;
	}
}