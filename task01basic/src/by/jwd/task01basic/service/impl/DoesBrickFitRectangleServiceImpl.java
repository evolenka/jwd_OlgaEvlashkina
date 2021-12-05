package by.jwd.task01basic.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.service.RectangleLogicService;
import by.jwd.task01basic.service.RectangleService;
import by.jwd.task01basic.service.ServiceException;

/*31 conditional task: There are the measures of the rectangle and the measures of the brick (x,y,z).
Does the brick fit the rectangle hole?*/

public class DoesBrickFitRectangleServiceImpl implements RectangleLogicService {

	/**
	 * Find out whether the brick with measures x,y,z fits into the rectangle hole
	 * with measures a,b
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param rectangle with measures a,b; numberData (list of x,y,z)
	 * @return boolean {@code true} if the brick fits into the rectangle hole;
	 *         {@code false} otherwise
	 * @exception ServiceException
	 * @throws ServiceException if the argument is invalid (negative or 0)
	 */

	static Logger logger = LogManager.getLogger(DoesBrickFitRectangleServiceImpl.class);

	public boolean doLogic(Rectangle rectangle, NumberData<Double> numberData) throws ServiceException {

		try {
			// validation
			if (numberData.getNumberData().get(0) <= 0 || numberData.getNumberData().get(1) <= 0
					|| numberData.getNumberData().get(2) <= 0) {
				throw new IllegalArgumentException();
			}

			RectangleService rectangleService = new RectangleAreaServiceImpl();

			double rectangleArea;
			rectangleArea = rectangleService.doCalculation(rectangle);

			double x;
			double y;
			double z;

			x = numberData.getNumberData().get(0);
			y = numberData.getNumberData().get(1);
			z = numberData.getNumberData().get(2);

			return rectangleArea > x * y && rectangleArea > y * z && rectangleArea > x * z;
		} catch (IllegalArgumentException e) {
			logger.error("negative number (or = 0)");
			throw new ServiceException();
		}
	}
}