package by.jwd.task02array.service;

import by.jwd.task02array.entity.Matrix;

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

	public <T extends Number> Matrix<T> doOperation(Matrix<T> p, Matrix<T> q) throws ServiceException;
}