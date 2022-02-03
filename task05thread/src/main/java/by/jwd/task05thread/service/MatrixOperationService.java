package by.jwd.task05thread.service;

import by.jwd.task05thread.entity.Matrix;

public interface MatrixOperationService {
	/**
	 * Arithmetic operations with matrixes
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param p, q
	 * @return <T extends Number> Matrix<T>
	 * @exception ServiceException
	 * @throws ServiceException if the file not found, invalid data in file
	 */

	public <T extends Number & Comparable <T>> Matrix<T> doOperation(Matrix<T> p, Matrix<T> q) throws ServiceException;
}