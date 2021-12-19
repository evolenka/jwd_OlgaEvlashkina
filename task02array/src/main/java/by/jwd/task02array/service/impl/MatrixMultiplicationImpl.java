package by.jwd.task02array.service.impl;

import by.jwd.task02array.entity.Matrix;
import by.jwd.task02array.entity.MatrixException;
import by.jwd.task02array.service.MatrixOperationService;
import by.jwd.task02array.service.ServiceException;

/** Multiplication of matrixes
* 
* @author evlashkina
* @version 1
* @param p, q
* @return Matrix <Integer>
* @exception ServiceException
* @throws ServiceException if the file not found, invalid data
*/

public class MatrixMultiplicationImpl implements MatrixOperationService<Integer> {

	public Matrix<Integer> doOperation(Matrix<Integer> p, Matrix<Integer> q) throws ServiceException {
		try {
			int v = p.getRowQuantity();
			int h = q.getColumnQuantity();
			int controlSize = p.getRowQuantity();
			if (controlSize != q.getColumnQuantity()) {
				throw new MatrixException();
			}

			Integer[][] matrix = new Integer[v][h];
			Matrix<Integer> result = new Matrix<>(matrix);

			for (int i = 0; i < v; i++) {
				for (int j = 0; j < h; j++) {
					int value = 0;
					for (int k = 0; k < controlSize; k++) {
						value += p.getElement(i, k) * q.getElement(k, j);
					}
					result.setElement(i, j, value);
				}
			}
			return result;

		} catch (MatrixException e) {
			throw new ServiceException();
		}
	}
}