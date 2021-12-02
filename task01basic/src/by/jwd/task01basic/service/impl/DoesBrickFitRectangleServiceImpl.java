package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.service.RectangleLogicService;
import by.jwd.task01basic.service.RectangleService;

/*31 conditional task: There are the measures of the rectangle and the measures of the brick (x,y,z).
Does the brick fit the rectangle hole?*/

public class DoesBrickFitRectangleServiceImpl implements RectangleLogicService {

	/**
	 * Find out whethre the brick with measures x,y,z fit into the rectangle hole
	 * with measures a,b
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param rectangle with measures a,b; numberData (list of x,y,z)
	 * @return boolean {@code true} if the brick fits into the rectangle hole;
	 *         {@code false} otherwise
	 */

	public boolean doLogic(Rectangle rectangle, NumberData<Double> numberData) {

		boolean result;

		RectangleService rectangleService = new RectangleAreaServiceImpl();

		double rectangleArea;

		rectangleArea = rectangleService.doCalculation(rectangle);

		double x;
		double y;
		double z;

		x = numberData.getNumberData().get(0);
		y = numberData.getNumberData().get(1);
		z = numberData.getNumberData().get(2);

		result = rectangleArea > x * y && rectangleArea > y * z && rectangleArea > x * z;
		return result;
	}
}