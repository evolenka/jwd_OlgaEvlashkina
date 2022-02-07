package by.jwd.task05thread.service;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.entity.Matrix;
import by.jwd.task05thread.entity.MatrixException;

/**
 * Class MatrixAdditionThread<T extends Number & Comparable<T>> implements
 * Runnable. The thread makes partial addition of two matrixes by one matrix row
 * 
 * @author evlashkina
 * @version 1
 */
public class MatrixAdditionThread<T extends Number & Comparable<T>> implements Runnable {

	static Logger logger = LogManager.getLogger(MatrixAdditionThread.class);

	private static int errorIndex;// return index of interruptedThread

	private Phaser phaser;
	private String name;
	private int index;
	private int quantity;
	private Matrix<T> p;
	private Matrix<T> q;
	private Matrix<T> result;

	public MatrixAdditionThread(Phaser phaser, String name, int index, int quantity, Matrix<T> p, Matrix<T> q,
			Matrix<T> result) {

		this.phaser = phaser;
		this.index = index;
		this.quantity = quantity;
		this.p = p;
		this.q = q;
		this.result = result;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getErrorIndex() {
		return errorIndex;
	}

	public static void setErrorIndex(int errorIndex) {
		MatrixAdditionThread.errorIndex = errorIndex;
	}

	@SuppressWarnings("unchecked") // unchecked cast from Double to T
	@Override
	public void run() {
		logger.debug("thread has started the addition: {}", getName());

		try {

			// index of first row which should be taken by current thread for calculation
			int startRowIndex = index * quantity;

			for (int i = startRowIndex; i < startRowIndex + quantity; i++) {
				for (int j = 0; j < p.getColumnQuantity(); j++) {

					Double value = p.getElement(startRowIndex, j).doubleValue()
							+ q.getElement(startRowIndex, j).doubleValue();
					result.setElement(startRowIndex, j, (T) value);// unchecked cast from Double to T
				}
			}

			TimeUnit.MILLISECONDS.sleep(500);

		} catch (InterruptedException | MatrixException e) {
			MatrixAdditionThread.setErrorIndex(index);// remember index of interrupted thread
			Thread.currentThread().interrupt();
			logger.error("matrix addition has not been completed by the interrupted thread {}", index);
		}
		if (!Thread.currentThread().isInterrupted()) {
			phaser.arrive();
			phaser.arriveAndDeregister();
			logger.debug("thread has finished the phase addition: {}", getName());
		}
		logger.debug(result);
	}
}