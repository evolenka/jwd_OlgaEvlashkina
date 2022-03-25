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
 * Runnable. The thread makes partial transposition of the matrix row
 * 
 * @author evlashkina
 * @version 1
 */
public class MatrixTranspositionThread<T extends Number & Comparable<T>> implements Runnable {

	static Logger logger = LogManager.getLogger(MatrixTranspositionThread.class);

	private CyclicBarrier barrier;
	private int quantity;
	private int index;
	private Matrix<T> p;
	private Matrix<T> result;

	public MatrixTranspositionThread(CyclicBarrier barrier, int index, int quantity, Matrix<T> p, Matrix<T> result) {
		this.barrier = barrier;
		this.index = index;
		this.quantity = quantity;
		this.p = p;
		this.result = result;
	}

	@SuppressWarnings("unchecked") // unchecked cast from Double to T
	public void run() {

		logger.debug("thread has started the transposition: {}", Thread.currentThread().getName());

		try {

			// index of row for first element which should be put into te matrix by current
			// thread
			int startRowIndex = index * quantity / p.getRowQuantity();

			// index of column for first element which should be put into te matrix by
			// current thread
			int startColumnIndex = index * quantity - startRowIndex * p.getRowQuantity();

			while (quantity > 0 && startRowIndex < p.getRowQuantity()) {
				quantity--;

				if (startColumnIndex > startRowIndex) {

					Double temp = p.getElement(startRowIndex, startColumnIndex).doubleValue();
					result.setElement(startRowIndex, startColumnIndex, p.getElement(startColumnIndex, startRowIndex));
					result.setElement(startColumnIndex, startRowIndex, (T) temp);// unchecked cast from Double to T
				}
				if (startColumnIndex < p.getColumnQuantity() - 1) {
					startColumnIndex++;// go to the next column
				} else {
					startRowIndex++;// go to the next row
					startColumnIndex = 0;
				}
			}

			TimeUnit.MILLISECONDS.sleep(50);
			barrier.await();
		} catch (BrokenBarrierException | InterruptedException | MatrixException e) {

			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		logger.debug("thread has finished the transposition: {}", Thread.currentThread().getName());
	}
}