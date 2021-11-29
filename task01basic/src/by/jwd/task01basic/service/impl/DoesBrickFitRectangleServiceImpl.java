package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.service.RectangleLogicService;
import by.jwd.task01basic.service.RectangleService;

/*There are the measures of the rectangle and the measures of the brick (x,y,z).
Does the brick fit the rectangle hole?*/

public class DoesBrickFitRectangleServiceImpl  implements RectangleLogicService{

	public boolean doAction(Rectangle rectangle, NumberData<Double> numberData) {

		RectangleService rectangleService = new RectangleAreaServiceImpl();

		double rectangleArea;
		rectangleArea = rectangleService.doCalculation(rectangle);

		double x;
		double y;
		double z;

		x = numberData.getNumberData().get(0);
		y = numberData.getNumberData().get(1);
		z = numberData.getNumberData().get(2);

		boolean result = rectangleArea > x * y && rectangleArea > y * z && rectangleArea > x * z;
		return result;
	}
}