package jwd.task02array;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import by.jwd.task02array.entity.Matrix;
import by.jwd.task02array.service.MatrixOperationService;
import by.jwd.task02array.service.ServiceException;
import by.jwd.task02array.service.impl.MatrixMultiplicationImpl;

public class MatrixMultiplicationTest {

	MatrixOperationService<Integer> service = new MatrixMultiplicationImpl();

	@Test(description = "MatrixMultiplicationTestPositive1", groups = { "service" })
	public void testMatrixMultiplication1() throws ServiceException {

		Integer[][] a = new Integer[][] { { 1, 1 }, { 1, 1 } };
		Matrix<Integer> p = new Matrix<>(a);
		Integer[][] b = new Integer[][] { { 1, 1, }, { 1, 1 } };
		Matrix<Integer> q = new Matrix<>(b);
		Integer[][] c = new Integer[][] { { 2, 2 }, { 2, 2 } };
		Matrix<Integer> result = new Matrix<>(c);

		Matrix<Integer> actual = service.doOperation(p, q);
		Matrix<Integer> expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "MatrixMultiplicationTestPositive2", groups = { "service" })
	public void testMatrixMultiplication2() throws ServiceException {

		Integer[][] a = new Integer[][] { { 1, 2 }, { 3, 4 } };
		Matrix<Integer> p = new Matrix<>(a);
		Integer[][] b = new Integer[][] { { 5, 6 }, { 7, 8 } };
		Matrix<Integer> q = new Matrix<>(b);
		Integer[][] c = new Integer[][] { { 19, 22 }, { 43, 50 } };
		Matrix<Integer> result = new Matrix<>(c);

		Matrix<Integer> actual = service.doOperation(p, q);
		Matrix<Integer> expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "MatrixMultiplicationTestPositive3", groups = { "service" })
	public void testMatrixMultiplication3() throws ServiceException {

		Integer[][] a = new Integer[][] { { 0, 0, 0 }, { 0, 0, 0 } };
		Matrix<Integer> p = new Matrix<>(a);
		Integer[][] b = new Integer[][] { { 0, 0 }, { 0, 0 }, { 0, 0 } };
		Matrix<Integer> q = new Matrix<>(b);
		Integer[][] c = new Integer[][] { { 0, 0 }, { 0, 0 } };
		Matrix<Integer> result = new Matrix<>(c);

		Matrix<Integer> actual = service.doOperation(p, q);
		Matrix<Integer> expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "MatrixMultiplicationTestNegative", groups = {
			"service" }, expectedExceptions = ServiceException.class)

	public void testMatrixMultiplication4() throws ServiceException {

		Integer[][] a = new Integer[][] { { 6, 8 }, { 9, 10 }, { 11, 121 }, { 10, 15 } };
		Matrix<Integer> p = new Matrix<>(a);
		Integer[][] b = new Integer[][] { { 1, 10 }, { 51, 1 }, { 81, 10 } };
		Matrix<Integer> q = new Matrix<>(b);
		Matrix<Integer> result = null;

		Matrix<Integer> actual = service.doOperation(p, q);
		Matrix<Integer> expected = result;
		assertEquals(actual, expected);
	}
}