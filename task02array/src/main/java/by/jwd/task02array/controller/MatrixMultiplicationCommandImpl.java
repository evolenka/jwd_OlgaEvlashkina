package by.jwd.task02array.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.Matrix;
import by.jwd.task02array.service.ArrayCreator;
import by.jwd.task02array.service.ArraySortingService;
import by.jwd.task02array.service.MatrixCreator;
import by.jwd.task02array.service.MatrixOperationService;
import by.jwd.task02array.service.ServiceException;
import by.jwd.task02array.service.ServiceFactory;
import by.jwd.task02array.view.MessageManager;
import by.jwd.task02array.view.Output;

public class MatrixMultiplicationCommandImpl implements Command {

	static Logger logger = LogManager.getLogger(BubbleSortCommandImpl.class);

	@Override
	public void execute(MessageManager current, String[] param) {

		ServiceFactory servicefactory = ServiceFactory.getInstance();

		MatrixOperationService<Integer> service = servicefactory.getMatrixMultiplication();

		MatrixCreator matrixCreator = servicefactory.getMatrixCreator();

		Output view = new Output();

		try {

			String fileName1 = param[0];
			String fileName2 = param[1];
			int rowQuantity1 = Integer.parseInt(param[2]);
			int columnQuantity1 = Integer.parseInt(param[3]);
			int rowQuantity2 = Integer.parseInt(param[4]);
			int columnQuantity2 = Integer.parseInt(param[5]);

			Matrix<Integer> matrix1 = matrixCreator.createMatrixFromFile(fileName1, rowQuantity1, columnQuantity1);
			Matrix<Integer> matrix2 = matrixCreator.createMatrixFromFile(fileName2, rowQuantity2, columnQuantity2);
			Matrix<Integer> resultMatrix = service.doOperation(matrix1, matrix2);

			view.print(current.getString("res9") + resultMatrix.toString());
			
		} catch (ServiceException e) {
			logger.error("error");
			view.print(current.getString("err2"));
		}
	}
}
