package by.jwd.task05thread.service.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executors;

import by.jwd.task05thread.entity.MatrixException;
import by.jwd.task05thread.entity.Matrix;

import by.jwd.task05thread.service.MatrixMultiplicationThread;
import by.jwd.task05thread.service.MatrixOperationService;
import by.jwd.task05thread.service.ServiceException;

/**
 * Multithreading multiplication of two matrixes
 * 
 * @author evlashkina
 * @version 1
 * @param p, q
 * @return <T extends Number & Comparable<T>>
 * @exception ServiceException
 * @throws ServiceException if the matrixes are incompatible, thread has been
 *                          interrupted
 * @see MatrixMultiplicationThread.class
 */

public class MatrixMultiplicationImpl implements MatrixOperationService {

	static Logger logger = LogManager.getLogger(MatrixMultiplicationImpl.class);

	public <T extends Number & Comparable<T>> Matrix<T> doOperation(Matrix<T> p, Matrix<T> q) throws ServiceException {

		try {
			if (p.getColumnQuantity() != q.getRowQuantity()) {
				throw new MatrixException();
			}

			int numberOfThreads = Runtime.getRuntime().availableProcessors();

			Double[][] matrix = new Double[p.getRowQuantity()][q.getColumnQuantity()];

			@SuppressWarnings("unchecked")
			Matrix<T> result = (Matrix<T>) new Matrix<>(matrix);// unchecked cast from Double to T

			ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

			Future<Matrix<T>> future = null;

			/* запускаем потоки, осуществляющие вычисления по iой строке первой матрицы*/

			for (int i = 0; i < p.getRowQuantity(); i++) {
				future = executor.submit(new MatrixMultiplicationThread<T>(i, p, q, result));
			}
			/*
			 * после выполнения всех расчетов останавливаем запуск новых потоков,
			 * останавливаем поток, в котором вызван данный метод (ожидаем завершение всех
			 * потоков,запущенных executer)
			 */
			executor.shutdown();
			executor.awaitTermination(1, TimeUnit.MINUTES);

			if (future != null) {
				logger.debug("multiplication has been finished successfully");
				result = future.get();
			}
			return result;
		} catch (InterruptedException | ExecutionException | MatrixException e) {
			Thread.currentThread().interrupt();
			throw new ServiceException();
		}
	}
}
