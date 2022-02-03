package by.jwd.task05thread.service;

import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.entity.Matrix;
import by.jwd.task05thread.entity.MatrixException;

/**
 * Class MatrixMultiplicationThread<T extends Number & Comparable<T>> implements
 * Callable<Matrix<T>>. The thread makes partial multiplication of the
 * two matrixes by calculating the value of the resulting matrix elements
 * [index][j], where index - row of the first matrix (passed as argument) and j
 * - columns of the second matrix
 * 
 * @author evlashkina
 * @version 1
 */

public class MatrixMultiplicationThread<T extends Number & Comparable<T>> implements Callable<Matrix<T>> {

	static Logger logger = LogManager.getLogger(MatrixMultiplicationThread.class);

	private int index;
	private Matrix<T> p;
	private Matrix<T> q;
	private Matrix<T> result;

	public MatrixMultiplicationThread(int index, Matrix<T> p, Matrix<T> q, Matrix<T> result) {

		this.index = index;
		this.p = p;
		this.q = q;
		this.result = result;
	}

	@SuppressWarnings("unchecked") // unchecked cast from Double to T
	@Override
	public Matrix<T> call() throws ServiceException {

		logger.debug("thread has started the multiplication: {}", Thread.currentThread().getName());
		try {

			for (int j = 0; j < q.getColumnQuantity(); j++) {
				Double value = 0.0;
				for (int k = 0; k < p.getColumnQuantity(); k++) {

					value += p.getElement(index, k).doubleValue() * (q.getElement(k, j).doubleValue());

				}

				result.setElement(index, j, (T) value);// unchecked cast from Double to T
				logger.debug("the value of calculated element= {}", value);
			}
		} catch (MatrixException e) {
			throw new ServiceException();
		}
		logger.debug("thread has finished the multiplication: {}", Thread.currentThread().getName());
		return result;
	}
}