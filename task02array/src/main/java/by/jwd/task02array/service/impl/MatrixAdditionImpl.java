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
 * @return Matrix <Integer>
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data
 */

public class MatrixAdditionImpl implements MatrixOperationService<Integer> {

	public Matrix<Integer> doOperation(Matrix<Integer> p, Matrix<Integer> q) throws ServiceException {
		try {
			int a = p.getRowQuantity();
			int b = q.getRowQuantity();
			int c = p.getColumnQuantity();
			int d = q.getColumnQuantity();

			if (a != b || c != d) {
				throw new MatrixException();
			}
			Integer[][] matrix = new Integer[a][c];
			Matrix<Integer> result = new Matrix<>(matrix);

			for (int i = 0; i < a; i++) {
				for (int j = 0; j < c; j++) {
					int value = p.getElement(i, j) + q.getElement(i, j);
					result.setElement(i, j, value);
				}
			}
			return result;

		} catch (MatrixException e) {
			throw new ServiceException();
		}
	}
}