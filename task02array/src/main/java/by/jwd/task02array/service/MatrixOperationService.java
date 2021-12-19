package by.jwd.task02array.service;

import by.jwd.task02array.entity.Matrix;

public interface MatrixOperationService<T> {
	/**
	 * Arithmetic operations with matrixes
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param p, q
	 * @return Matrix <T>
	 * @exception ServiceException
	 * @throws ServiceException if the file not found, invalid data in file
	 */

	public Matrix<T> doOperation(Matrix<T> p, Matrix<T> q) throws ServiceException;
}