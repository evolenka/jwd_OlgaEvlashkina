package by.jwd.task02array.service.impl;

import by.jwd.task02array.entity.Matrix;
import by.jwd.task02array.entity.MatrixException;
import by.jwd.task02array.service.ServiceException;

public class MatrixAdditionImpl {

	public Matrix<Integer> add(Matrix<Integer> p, Matrix<Integer> q) throws ServiceException {
		try {
			int a = p.getRowQuantity();
			int b = q.getRowQuantity();
			int c = p.getColumnQuantity();
			int d = q.getColumnQuantity();

			if (a != b || c != d) {
				throw new MatrixException();
			}
			Matrix<Integer> result = new Matrix<Integer>(a, c);

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