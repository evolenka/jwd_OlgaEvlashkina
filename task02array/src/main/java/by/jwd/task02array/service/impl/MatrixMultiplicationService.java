package by.jwd.task02array.service.impl;

import by.jwd.task02array.entity.Matrix;
import by.jwd.task02array.entity.MatrixException;
import by.jwd.task02array.service.ServiceException;

public class MatrixMultiplicationService {

	public Matrix<Integer> multiply(Matrix<Integer> p, Matrix<Integer> q) throws ServiceException {
		try {
			int v = p.getRowQuantity();
			int h = q.getColumnQuantity();
			int controlSize = p.getRowQuantity();
			if (controlSize != q.getColumnQuantity()) {
				throw new MatrixException();
			}
			Matrix<Integer> result = new Matrix<Integer>(v, h);

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