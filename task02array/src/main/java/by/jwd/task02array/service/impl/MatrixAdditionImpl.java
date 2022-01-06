package by.jwd.task02array.service.impl;

import by.jwd.task02array.entity.Matrix;
import by.jwd.task02array.entity.MatrixException;
import by.jwd.task02array.service.MatrixOperationService;
import by.jwd.task02array.service.ServiceException;

/**
 * Addition of matrixes
 * 
 * @author evlashkina
 * @version 1
 * @param p, q
 * @return <T extends Number> Matrix <T>
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data
 */

public class MatrixAdditionImpl implements MatrixOperationService {

	
	@SuppressWarnings("unchecked")// unchecked cast from Double to T
	public <T extends Number> Matrix<T> doOperation(Matrix<T> p, Matrix<T> q) throws ServiceException {
		try {
			int a = p.getRowQuantity();
			int b = q.getRowQuantity();
			int c = p.getColumnQuantity();
			int d = q.getColumnQuantity();

			if (a != b || c != d) {
				throw new MatrixException();
			}
	
			T[][] matrix = (T [] []) new Double[a][c];
			Matrix<T> result = new Matrix<>(matrix);

			for (int i = 0; i < a; i++) {
				for (int j = 0; j < c; j++) {
					Double value = (Double) p.getElement(i, j) + (Double) q.getElement(i, j);
					result.setElement(i, j, ((T) value));
				}
			}
			return result;

		} catch (MatrixException e) {
			throw new ServiceException();
		}
	}
}