package by.jwd.task05thread.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.controller.Command;
import by.jwd.task05thread.entity.Matrix;
import by.jwd.task05thread.service.MatrixCreator;
import by.jwd.task05thread.service.MatrixOperationService;
import by.jwd.task05thread.service.ServiceException;
import by.jwd.task05thread.service.ServiceFactory;
import by.jwd.task05thread.view.MessageManager;
import by.jwd.task05thread.view.Output;

public class MatrixMultiplicationCommandImpl implements Command {

	static Logger logger = LogManager.getLogger(MatrixMultiplicationCommandImpl.class);

	@Override
	public <T extends Number & Comparable<T>> void execute(MessageManager current, String[] param) {

		ServiceFactory servicefactory = ServiceFactory.getInstance();
		MatrixOperationService service = ServiceFactory.getInstance().getMatrixMultiplication();
		MatrixCreator matrixCreator = servicefactory.getMatrixCreator();

		Output view = new Output();

		try {
			String fileName1 = param[0];
			logger.debug("fileName1 = {}", fileName1);
			
			String fileName2 = param[1];
			logger.debug("fileName2 = {}", fileName2);
			
			int rowQuantity1 = Integer.parseInt(param[2]);
			logger.debug("rowQuantity1 = {}", rowQuantity1);
			
			int columnQuantity1 = Integer.parseInt(param[3]);
			logger.debug("columnQuantity1 = {}", columnQuantity1 );
			
			int rowQuantity2 = Integer.parseInt(param[4]);
			logger.debug("rowQuantity2 = {}", rowQuantity2);
			
			int columnQuantity2 = Integer.parseInt(param[5]);
			logger.debug("columnQuantity2 =  {}", columnQuantity2 );

			Matrix<T> matrix1 = matrixCreator.createMatrixFromFile(fileName1, rowQuantity1, columnQuantity1);
			Matrix<T> matrix2 = matrixCreator.createMatrixFromFile(fileName2, rowQuantity2, columnQuantity2);

			Matrix<T> resultMatrix = service.doOperation(matrix1, matrix2);

			view.print(Thread.currentThread().getName() + ": " + current.getString("res9") + resultMatrix.toString());

		} catch (ServiceException e) {
			logger.error("error");
			view.print(current.getString("err2"));

		} catch (NumberFormatException e) {
			logger.error("wrong number format");
			view.print(current.getString("err4"));

		} catch (ArrayIndexOutOfBoundsException e) {
			logger.error("wrong quantity of args");
			view.print(current.getString("err5"));
		}
	}
}
