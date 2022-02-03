package by.jwd.task05thread.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.dao.DaoException;
import by.jwd.task05thread.dao.DaoFactory;
import by.jwd.task05thread.entity.Matrix;

/**
 * Creation of matrix from File
 * 
 * @author evlashkina
 * @version 1
 * @param fileName, rowQuantity, columnQuantity
 * @return Matrix<Integer>
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data in file
 */

public class MatrixCreator {

	static Logger logger = LogManager.getLogger(MatrixCreator.class);

	private final DaoFactory daofactory = DaoFactory.getInstance();

	@SuppressWarnings("unchecked") // unchecked cast from Matrix <Double> to Matrix <T>

	public <T extends Number> Matrix<T> createMatrixFromFile(String fileName, int rowQuantity, int columnQuantity)
			throws ServiceException {

		if (rowQuantity <= 0 || columnQuantity <= 0) {
			throw new ServiceException();
		}

		Matrix<T> matrix = null;
//		
//		try {
//
//			List<String> param = daofactory.getReader().readDataFromFile(fileName);
//
//			if (param != null) {
//
//				DataParser parser = DataParser.getInstance();
//				String[] parsedParam = parser.parse(param, 0);
//
//		ConcurrentHashMap<Integer, Double> rows = new ConcurrentHashMap <>();
//		
//		int k = 0;
//		for (int i = 0; i < rowQuantity; i++) {
//			for (int j = 0; j < columnQuantity; j++) {
//				h.put(i, Double.valueOf(parsedParam[k]));
//				k++;
//			}
//		}
//		
//		Set <Integer> hset = ConcurrentHashMap.newKeySet();
//		for (int i = 0; i < rowQuantity*columnQuantity; i++) {
//		hset.add(i);
//		}
//		
//		hset.add(Double.valueOf(parsedParam[k]))
//		
//		Iterator<Integer>iterator = hset.iterator();
//	    while (iterator.hasNext()) {
//	    	
//	        mInfoTextView.setText(mInfoTextView.getText() + iterator.next()
//	                + ", ");
//	    }
//	}
//		Iterator <Double> i = h.iterator();
//		while (i.hasNext())

		try {

			List<String> param = daofactory.getReader().readDataFromFile(fileName);

			if (param != null) {

				DataParser parser = DataParser.getInstance();
				String[] parsedParam = parser.parse(param, 0);

				Double[][] m = new Double[rowQuantity][columnQuantity];

				int k = 0;
				for (int i = 0; i < m.length; i++) {
					for (int j = 0; j < m[0].length; j++) {
						m[i][j] = Double.valueOf(parsedParam[k]);
						k++;
					}
				}

				matrix = (Matrix<T>) new Matrix<>(m);// unchecked cast from Matrix <Double> to Matrix <T>
			}

		} catch (NumberFormatException | DaoException e) {
			throw new ServiceException();
		}
		logger.debug("matrix has been created: {}", Thread.currentThread().getName());
		return matrix;
	}
}