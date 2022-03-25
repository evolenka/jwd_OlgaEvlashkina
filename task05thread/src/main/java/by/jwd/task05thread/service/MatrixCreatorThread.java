package by.jwd.task05thread.service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.entity.Matrix;
import by.jwd.task05thread.entity.MatrixException;

/**
 * Class MatrixCreator<T extends Number & Comparable<T>> extends Thread. The
 * thread makes partial initialization of matrix elements
 *
 * 
 * @author evlashkina
 * @version 1
 */
public class MatrixCreatorThread<T extends Number> extends Thread {

	static Logger logger = LogManager.getLogger(MatrixCreatorThread.class);

	private static int errorIndex;// return index of interruptedThread

	private String[] param;
	private Matrix<T> matrix;
	private int index;
	private int quantity;
	private CountDownLatch countDown;

	public static int getErrorIndex() {
		return errorIndex;
	}

	public static void setErrorIndex(int errorIndex) {
		MatrixCreatorThread.errorIndex = errorIndex;
	}

	public MatrixCreatorThread(CountDownLatch countDown, String[] param, Matrix<T> matrix, int index, int quantity) {

		this.countDown = countDown;
		this.param = param;
		this.matrix = matrix;
		this.quantity = quantity;
		this.index = index;
	}

	@SuppressWarnings("unchecked") // unchecked cast from Double to T
	@Override
	public void run() {
		try {
			logger.debug("thread has started creating of matrix: {}", Thread.currentThread().getName());

			// index of first element which should be taken from param [] by current thread
			int startParamIndex = index * quantity;

			// index of last element which should be taken from param by current thread
			int endParamIndex = startParamIndex + quantity;

			// index of row for first element which should be put into te matrix by current
			// thread
			int startRowIndex = index * quantity / matrix.getColumnQuantity();

			// index of column for first element which should be put into te matrix by
			// current thread
			int startColumnIndex = index * quantity - startRowIndex * matrix.getColumnQuantity();
				
			while (startParamIndex < endParamIndex
					&& startParamIndex < matrix.getRowQuantity() * matrix.getColumnQuantity()) {
				
				// unchecked cast from Double to T
				matrix.setElement(startRowIndex, startColumnIndex, (T) Double.valueOf(param[startParamIndex]));
				
				startParamIndex++;

				if (startColumnIndex < matrix.getColumnQuantity() - 1) {
					startColumnIndex++;// go to the next column
				} else {
					startColumnIndex = 0;
					startRowIndex++;// go to the next row
				}
			}
			TimeUnit.MILLISECONDS.sleep(50);

		} catch (InterruptedException | NumberFormatException | MatrixException e) {
			MatrixCreatorThread.setErrorIndex(index);// remember index of interrupted thread
			Thread.currentThread().interrupt();
			logger.error("matrix creating has not completed by the interrupted thread {}", index);

		}
		if (!isInterrupted()) {
			countDown.countDown();// decrease the latch
			logger.debug("thread has finished the creating of matrix: {}", Thread.currentThread().getName());
		}
	logger.debug(matrix);
}
}