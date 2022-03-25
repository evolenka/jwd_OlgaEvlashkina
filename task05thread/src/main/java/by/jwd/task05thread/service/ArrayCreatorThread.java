package by.jwd.task05thread.service;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.entity.Array;
import by.jwd.task05thread.entity.ArrayException;

/**
 * Class ArrayCreator<T extends Number & Comparable<T>> extends Thread. The
 * thread makes partial initialization of array elements
 * 
 * @author evlashkina
 * @version 1
 */

public class ArrayCreatorThread<T extends Number> extends Thread {

	static Logger logger = LogManager.getLogger(ArrayCreatorThread.class);

	private ConcurrentHashMap<Integer, Double> paramHashMap;
	private Array<T> array;
	private int quantity;

	public ArrayCreatorThread(String name, ConcurrentHashMap<Integer, Double> paramHashMap, Array<T> array,
			int quantity) {

		super(name);
		this.paramHashMap = paramHashMap;
		this.array = array;
		this.quantity = quantity;
	}

	@SuppressWarnings("unchecked") // unchecked cast from Double to T
	@Override
	public void run() {
		try {
			logger.debug("thread has started creating of array: {}", Thread.currentThread().getName());

			int index;
			Iterator<ConcurrentHashMap.Entry<Integer, Double>> itr = paramHashMap.entrySet().iterator();

			// put part of the elements from collection to the array, delete from collection
			// the element, which has been already added to the array, 

			while (itr.hasNext() && quantity > 0) {

				ConcurrentHashMap.Entry<Integer, Double> entry = itr.next();
				index = entry.getKey();
				array.setElement(index, (T) entry.getValue());
				paramHashMap.remove(entry.getKey(), entry.getValue());
				quantity--;
			}

			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException| ArrayException e) {
			logger.error("thread has been interrupted");
			Thread.currentThread().interrupt();
		}
		logger.debug("thread has finished the creating of array: {}", Thread.currentThread().getName());
		logger.debug(array);
	}
}