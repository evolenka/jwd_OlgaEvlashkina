package by.jwd.task05thread.service.impl;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.entity.Matrix;
import by.jwd.task05thread.service.MatrixTranspositionThread;
import by.jwd.task05thread.service.ServiceException;

/**
 * Multithreading transposition of two matrixes
 * 
 * @author evlashkina
 * @version 1
 * @param p
 * @return <T extends Number & Comparable<T>>
 * @exception ServiceException
 * @throws ServiceException if the thread has been interrupted
 * @see MatrixTranspositionThread.class
 */

public class MatrixTransposition {

	static Logger logger = LogManager.getLogger(MatrixTransposition.class);

	public <T extends Number & Comparable<T>> Matrix<T> doOperation(Matrix<T> p) throws ServiceException {

		Matrix<T> result = p;

		// создаем барьер с количеством запускаемых потоков для транспонирования матрицы
		// + поток, выполняющий данный метод
		CyclicBarrier barrier = new CyclicBarrier(p.getRowQuantity() + 1);

		for (int i = 0; i < p.getRowQuantity(); i++) {

			Thread t = new Thread(new MatrixTranspositionThread<T>(barrier, i, p, result));
			t.setName("Thread " + i);
			t.start();
		}
		try {
			// ожидаем, пока все потоки подойдут к барьеру
			barrier.await();
			logger.debug("matrix transposition has been completed");
			return result;
		} catch (BrokenBarrierException | InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new ServiceException();
		}
	}
}