package jwd.task02array;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import by.jwd.task05thread.entity.Matrix;
import by.jwd.task05thread.service.MatrixOperationService;
import by.jwd.task05thread.service.ServiceException;
import by.jwd.task05thread.service.impl.MatrixMultiplicationImpl;

public class MatrixMultiplicationTest {

	MatrixOperationService service = new MatrixMultiplicationImpl();

	@Test(description = "MatrixMultiplicationTestPositive1", groups = { "service" })
	public void testMatrixMultiplication1() throws ServiceException {

		Double[][] a = new Double[][] { { 1.0, 1.0 }, { 1.0, 1.0 } };
		Matrix<Double> p = new Matrix<>(a);
		Double[][] b = new Double[][] { { 1.0, 1.0, }, { 1.0, 1.0 } };
		Matrix<Double> q = new Matrix<>(b);
		Double[][] c = new Double[][] { { 2.0, 2.0 }, { 2.0, 2.0 } };
		Matrix<Double> result = new Matrix<>(c);

		Matrix<Double> actual = service.doOperation(p, q);
		Matrix<Double> expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "MatrixMultiplicationTestPositive2", groups = { "service" })
	public void testMatrixMultiplication2() throws ServiceException {

		Double[][] a = new Double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } };
		Matrix<Double> p = new Matrix<>(a);
		Double[][] b = new Double[][] { { 5.0, 6.0 }, { 7.0, 8.0 } };
		Matrix<Double> q = new Matrix<>(b);
		Double[][] c = new Double[][] { { 19.0, 22.0 }, { 43.0, 50.0 } };
		Matrix<Double> result = new Matrix<>(c);

		Matrix<Double> actual = service.doOperation(p, q);
		Matrix<Double> expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "MatrixMultiplicationTestPositive3", groups = { "service" })
	public void testMatrixMultiplication3() throws ServiceException {

		Double[][] a = new Double[][] { { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 } };
		Matrix<Double> p = new Matrix<>(a);
		Double[][] b = new Double[][] { { 0.0, 0.0 }, { 0.0, 0.0 }, { 0.0, 0.0 } };
		Matrix<Double> q = new Matrix<>(b);
		Double[][] c = new Double[][] { { 0.0, 0.0 }, { 0.0, 0.0 } };
		Matrix<Double> result = new Matrix<>(c);

		Matrix<Double> actual = service.doOperation(p, q);
		Matrix<Double> expected = result;
		assertEquals(actual, expected);
	}

	@Test(description = "MatrixMultiplicationTestNegative", groups = {
			"service" }, expectedExceptions = ServiceException.class)

	public void testMatrixMultiplication4() throws ServiceException {

		Double[][] a = new Double[][] { { 6.0, 8.0 }, { 9.0, 10.0 }, { 11.0, 121.0 }, { 10.0, 15.0 } };
		Matrix<Double> p = new Matrix<>(a);
		Double[][] b = new Double[][] { { 1.0, 10.0 }, { 51.0, 1.0 }, { 81.0, 10.0 } };
		Matrix<Double> q = new Matrix<>(b);
		Matrix<Double> result = null;

		Matrix<Double> actual = service.doOperation(p, q);
		Matrix<Double> expected = result;
		assertEquals(actual, expected);
	}
}