package by.jwd.task05thread.service;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.entity.Matrix;
import by.jwd.task05thread.entity.MatrixException;

/**
 * Class MatrixTranspositionThread<T extends Number & Comparable<T>> implements
 * Runnable. The thread makes partial transposition of the
 * matrix row 
 * 
 * @author evlashkina
 * @version 1
 */
public class MatrixTranspositionThread<T extends Number & Comparable<T>> implements Runnable {

	static Logger logger = LogManager.getLogger(MatrixTranspositionThread.class);

	private int index;
	private CyclicBarrier barrier;
	private Matrix<T> p;
	private Matrix<T> result;

	public MatrixTranspositionThread(CyclicBarrier barrier, int index, Matrix<T> p, Matrix<T> result) {

		this.index = index;
		this.p = p;
		this.result = result;
		this.barrier = barrier;
	}

	@SuppressWarnings("unchecked") // unchecked cast from Double to T
	public void run() {

		logger.debug("thread has started the transposition: {}", Thread.currentThread().getName());

		try {

			for (int j = index + 1; j < p.getColumnQuantity(); j++) {

				Double temp = p.getElement(index, j).doubleValue();
				result.setElement(index, j, p.getElement(j, index));
				TimeUnit.MILLISECONDS.sleep(1500);
				result.setElement(j, index, (T) temp);// unchecked cast from Double to T
				logger.debug("result: {}", Thread.currentThread().getName());
			
			}
			barrier.await();
			logger.debug("thread has finished the transposition: {}", Thread.currentThread().getName());
		} catch (BrokenBarrierException| InterruptedException | MatrixException e) {
			Thread.currentThread().interrupt();
			logger.debug("matrixException, thread has been interrupted");
		}
	}
}