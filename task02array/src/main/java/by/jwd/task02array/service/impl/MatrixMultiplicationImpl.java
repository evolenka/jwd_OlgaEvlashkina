package by.jwd.task02array.service.impl;

import by.jwd.task02array.entity.Matrix;
import by.jwd.task02array.entity.MatrixException;
import by.jwd.task02array.service.MatrixOperationService;
import by.jwd.task02array.service.ServiceException;

/**
 * Multiplication of matrixes
 * 
 * @author evlashkina
 * @version 1
 * @param p, q
 * @return <T extends Number> Matrix <T>
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data
 */

public class MatrixMultiplicationImpl implements MatrixOperationService {

	@SuppressWarnings("unchecked") // unchecked cast from Double to T
	public <T extends Number> Matrix<T> doOperation(Matrix<T> p, Matrix<T> q) throws ServiceException {
		try {
			int v = p.getRowQuantity();
			int h = q.getColumnQuantity();
			int controlSize = p.getRowQuantity();
			if (controlSize != q.getColumnQuantity()) {
				throw new MatrixException();
			}

			T[][] matrix = (T[][]) new Double[v][h];
			Matrix<T> result = new Matrix<>(matrix);

			for (int i = 0; i < v; i++) {
				for (int j = 0; j < h; j++) {
					Double value = 0.0;
					for (int k = 0; k < controlSize; k++) {
						value += (Double) p.getElement(i, k) * ((Double) q.getElement(k, j));
					}
					result.setElement(i, j, (T) value);
				}
			}
			return result;

		} catch (MatrixException e) {
			throw new ServiceException();
		}
	}
}