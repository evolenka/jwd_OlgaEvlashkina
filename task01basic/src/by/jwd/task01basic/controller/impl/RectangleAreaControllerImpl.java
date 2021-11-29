package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.service.RectangleService;
import by.jwd.task01basic.service.impl.RectangleAreaServiceImpl;
import by.jwd.task01basic.view.Output;

public class RectangleAreaControllerImpl implements Command {

	Output output = new Output();
	RectangleService rectangleService = new RectangleAreaServiceImpl();
	Rectangle rectangle = new Rectangle();

	@Override
	public String execute(String[] params) {

		double result;

		try {
			double length = Double.parseDouble(params[0]);

			if (length <= 0) {
				throw new IllegalArgumentException();
			}

			rectangle.setLength(length);
			rectangle.setWidth((length / 2));

			result = rectangleService.doCalculation(rectangle);
			return output.printResponce("The rectangle area =  ", Double.toString(result));

		} catch (NumberFormatException e) {
			return output.print("Incorrect input: incorrect format of numbers");

		} catch (IllegalArgumentException e) {
			return output.print("Incorrect input: number should be positive and can not be equal to 0");
		}
	}
}