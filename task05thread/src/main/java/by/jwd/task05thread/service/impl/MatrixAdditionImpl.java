package by.jwd.task05thread.service.impl;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.entity.Matrix;
import by.jwd.task05thread.entity.MatrixException;
import by.jwd.task05thread.service.MatrixAdditionThread;
import by.jwd.task05thread.service.MatrixOperationService;
import by.jwd.task05thread.service.ServiceException;

/**
 * Multithreading addition of two matrixes
 * 
 * @author evlashkina
 * @version 1
 * @param p, q
 * @return <T extends Number & Comparable<T>>
 * @exception ServiceException
 * @throws ServiceException if the matrixes are not incompatible, thread has
 *                          been interrupted
 * @see MatrixAdditionThread.class
 */

public class MatrixAdditionImpl implements MatrixOperationService {

	static Logger logger = LogManager.getLogger(MatrixAdditionImpl.class);
	
	@SuppressWarnings("unchecked") // unchecked cast from Double to T
	public <T extends Number & Comparable<T>> Matrix<T> doOperation(Matrix<T> p, Matrix<T> q) throws ServiceException {
		
		Matrix<T> result = null;
		try {

			if (p.getRowQuantity() != q.getRowQuantity() || p.getColumnQuantity() != q.getColumnQuantity()) {
				throw new MatrixException();
			}

			Double[][] matrix = new Double[p.getRowQuantity()][q.getColumnQuantity()];
			result = (Matrix<T>) new Matrix<>(matrix);// unchecked cast from Double to T

			int numberOfThreads = Runtime.getRuntime().availableProcessors();
						
			// calculate quantity of elements which each thread should put into the matrix
			int quantity;
			if (p.getRowQuantity() < numberOfThreads) {
				numberOfThreads = p.getRowQuantity();
				quantity = 1;
			} else {
				quantity = p.getRowQuantity() / numberOfThreads;
			}

			Phaser phaser = new Phaser(numberOfThreads);
			
			for (int i = 0; i < numberOfThreads; i++) {
				new Thread(new MatrixAdditionThread<T>(phaser, "PhaseThread " + i, i, quantity, p, q, result)).start();
				TimeUnit.MILLISECONDS.sleep(500);
			}

			TimeUnit.SECONDS.sleep(1);

			if (!phaser.isTerminated()) {
				int i = MatrixAdditionThread.getErrorIndex();
				Thread t = new Thread(new MatrixAdditionThread<T>(phaser, "ExtraMatrixAdditionThread", i, quantity,
						p, q, result));
				t.start();
				t.join();
			}
		} catch (InterruptedException | MatrixException e) {
			Thread.currentThread().interrupt();
			throw new ServiceException();
		}
		logger.debug("phase addition of two matrixes has been completed");
		return result;
	}
}