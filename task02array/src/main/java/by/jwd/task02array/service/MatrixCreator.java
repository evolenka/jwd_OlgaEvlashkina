package by.jwd.task02array.service;

import by.jwd.task02array.dao.DaoException;
import by.jwd.task02array.dao.DaoFactory;

import by.jwd.task02array.entity.Matrix;
import by.jwd.task02array.entity.MatrixException;

public class MatrixCreator {
	
	private final DaoFactory daofactory = DaoFactory.getInstance();

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
	
	public Matrix<Integer> createMatrixFromFile(String fileName, int rowQuantity, int columnQuantity)
			throws ServiceException {

		Matrix<Integer> matrix = null;

		try {
			
			String[] param = daofactory.getReader().readDataFromFile(fileName);

			if (param != null) {

				Integer[][] m = new Integer[rowQuantity][columnQuantity];
				matrix = new Matrix<>(m);
				int k = 0;
				for (int i = 0; i < matrix.getRowQuantity(); i++) {
					for (int j = 0; j < matrix.getColumnQuantity(); j++) {
						matrix.setElement(i, j, Integer.parseInt(param[k]));
						k++;
					}
				}
			}
			return matrix;
		} catch (NumberFormatException | MatrixException | DaoException e) {
			throw new ServiceException();
		}
	}
}