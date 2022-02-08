package by.jwd.task05thread.service.impl;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.entity.Matrix;
import by.jwd.task05thread.service.MatrixTranspositionThread;
import by.jwd.task05thread.service.ServiceException;

/**
 * Multithreading transposition of matrix
 * 
 * @author evlashkina
 * @version 1
 * @param p
 * @return <T extends Number & Comparable<T>>
 * @exception ServiceException
 * @throws ServiceException if thread has been interrupted
 * @see MatrixTranspositionThread.class
 */

public class MatrixTransposition {

	static Logger logger = LogManager.getLogger(MatrixTransposition.class);

	public <T extends Number & Comparable<T>> Matrix<T> doOperation(Matrix<T> p) throws ServiceException {

		Matrix<T> result = p;

		int numberOfThreads = Runtime.getRuntime().availableProcessors();

		CyclicBarrier barrier = new CyclicBarrier(numberOfThreads + 1);

		// calculate quantity of elements which each thread should put into the matrix
		int quantity = (p.getRowQuantity() * p.getColumnQuantity()) / numberOfThreads;

		try {
			for (int i = 0; i < numberOfThreads; i++) {

				Thread t = new Thread(new MatrixTranspositionThread<T>(barrier, i, quantity, p, result));
				t.setName("Thread " + i);
				t.start();
				TimeUnit.MILLISECONDS.sleep(500);
			}

			// wait until all threads have completed.
			barrier.await();

		} catch (BrokenBarrierException | InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.error("thread has been interrupted {}", Thread.currentThread().getName());
			throw new ServiceException();
		}
		logger.debug("matrix transposition has been completed");
		return result;
	}
}