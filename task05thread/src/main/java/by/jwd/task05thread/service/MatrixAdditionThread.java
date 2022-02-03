package by.jwd.task05thread.service;

import java.util.concurrent.Phaser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.entity.Matrix;
import by.jwd.task05thread.entity.MatrixException;

/**
 * Class MatrixAdditionThread<T extends Number & Comparable<T>> implements
 * Runnable. The thread makes partial addition of two matrixes by one
 * matrix row 
 * 
 * @author evlashkina
 * @version 1
 */
public class MatrixAdditionThread<T extends Number & Comparable<T>> implements Runnable {

	static Logger logger = LogManager.getLogger(MatrixAdditionThread.class);

	private Phaser phaser;
	private String name;
	private int index;
	private Matrix<T> p;
	private Matrix<T> q;
	private Matrix<T> result;

	public MatrixAdditionThread(Phaser phaser, String name, int index, Matrix<T> p, Matrix<T> q, Matrix<T> result) {

		this.phaser = phaser;
		this.index = index;
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

	@SuppressWarnings("unchecked") // unchecked cast from Double to T
	@Override
	public void run() {
		logger.debug("thread has started the addition: {}", getName());

		try {
			for (int k = 0; k < p.getColumnQuantity(); k++) {
				Double value = p.getElement(index, k).doubleValue() + q.getElement(index, k).doubleValue();
				result.setElement(index, k, (T) value);// unchecked cast from Double to T
			}

			phaser.arrive(); // сообщаем, что фаза достигнута
			logger.debug("thread has finished the phase addition: {}", getName());
			phaser.arriveAndDeregister(); // сообщаем о завершении и удаляем с регистрации объекты

		} catch (MatrixException e) {
			Thread.currentThread().interrupt();
			logger.debug("matrixException, thread has been interrupted");
		}
	}
}