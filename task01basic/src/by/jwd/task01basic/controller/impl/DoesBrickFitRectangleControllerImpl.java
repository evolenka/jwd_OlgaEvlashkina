package by.jwd.task01basic.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.service.RectangleLogicService;
import by.jwd.task01basic.service.impl.DoesBrickFitRectangleServiceImpl;
import by.jwd.task01basic.view.Output;

public class DoesBrickFitRectangleControllerImpl implements Command {

	Output output = new Output();
	RectangleLogicService service = new DoesBrickFitRectangleServiceImpl();
	NumberData<Double> numberData = new NumberData<>();
	Rectangle rectangle = new Rectangle();

	static Logger LOGGER = LogManager.getLogger(DoesBrickFitRectangleControllerImpl.class);

	@Override
	public String execute(String[] params) {

		boolean result;

		try {

			double length = Double.parseDouble(params[0]);
			double width = Double.parseDouble(params[1]);
			double x = Double.parseDouble(params[2]);
			double y = Double.parseDouble(params[3]);
			double z = Double.parseDouble(params[4]);

			if (length <= 0 || width <= 0 || x <= 0 || y <= 0 || z < 0) {
				throw new IllegalArgumentException();
			}

			rectangle.setLength(length);
			rectangle.setWidth(width);
			numberData.addNumberData(x);
			numberData.addNumberData(y);
			numberData.addNumberData(z);

			result = service.doAction(rectangle, numberData);

			if (result) {
				return output.print("The brick fits the rectangle hole");
			} else
				return output.print("The brick does not fit the rectangle hole");

		} catch (NumberFormatException e) {
			LOGGER.error("wrong format of args");
			return output.print("Incorrect input: wrong format of numbers");

		} catch (IllegalArgumentException e) {
			LOGGER.error("negative or 0");
			return output.print("Incorrect input: numbers should be positive and can not be equal to 0");

		} catch (ArrayIndexOutOfBoundsException e) {
			LOGGER.error("wrong guantity of args");
			return output.print("Incorrect input: five numbers are requested");
		}
	}
}