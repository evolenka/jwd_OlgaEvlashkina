package by.jwd.task05thread.service.impl;

import java.util.concurrent.Phaser;

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
 * @throws ServiceException if the thread has been interrupted
 * @see MatrixAdditionThread.class
 */

public class MatrixAdditionImpl implements MatrixOperationService {

	static Logger logger = LogManager.getLogger(MatrixAdditionImpl.class);

	public <T extends Number & Comparable<T>> Matrix<T> doOperation(Matrix<T> p, Matrix<T> q) throws ServiceException {
		try {
			if (p.getRowQuantity() != q.getRowQuantity() || p.getColumnQuantity() != q.getColumnQuantity()) {
				throw new MatrixException();
			}

			Double[][] matrix = new Double[p.getRowQuantity()][q.getColumnQuantity()];

			@SuppressWarnings("unchecked")
			Matrix<T> result = (Matrix<T>) new Matrix<>(matrix);// unchecked cast from Double to T

			Phaser phaser = new Phaser(p.getRowQuantity());

			for (int i = 0; i < p.getRowQuantity(); i++) {
				new Thread(new MatrixAdditionThread<T>(phaser, "PhaseThread " + i, i, p, q, result)).start();
				logger.debug("temp matrix result = {} ", result);
			}

			// ждем завершения фазы
			int phase = phaser.getPhase();
			phaser.arriveAndAwaitAdvance();
			phaser.arriveAndDeregister();
			logger.debug("phase addition of two matrixes has been completed, phase = {} ", phase);
			return result;
		} catch (MatrixException e) {
			throw new ServiceException();
		}
	}
}