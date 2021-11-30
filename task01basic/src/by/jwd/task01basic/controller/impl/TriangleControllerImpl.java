package by.jwd.task01basic.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.TriangleService;
import by.jwd.task01basic.service.impl.TriangleAreaServiceImpl;
import by.jwd.task01basic.service.impl.TriangleHeightServiceImpl;
import by.jwd.task01basic.service.impl.TriangleRadiusInServiceImpl;
import by.jwd.task01basic.service.impl.TriangleRadiusOutServiceImpl;
import by.jwd.task01basic.view.Output;

public class TriangleControllerImpl implements Command {

	Output output = new Output();
	TriangleService triangleService;
	
	static Logger LOGGER = LogManager.getLogger(TriangleControllerImpl.class);

	@Override
	public String execute(String[] params) {

		double area;
		double height;
		double radiusIn;
		double radiusOut;

		try {
			double length = Double.parseDouble(params[0]);
			if (length <= 0) {
				throw new IllegalArgumentException();
			}

			Triangle triangle = new Triangle(length, length, length);

			triangleService = new TriangleAreaServiceImpl();
			area = triangleService.doCalculation(triangle);

			triangleService = new TriangleHeightServiceImpl();
			height = triangleService.doCalculation(triangle);

			triangleService = new TriangleRadiusInServiceImpl();
			radiusIn = triangleService.doCalculation(triangle);

			triangleService = new TriangleRadiusOutServiceImpl();
			radiusOut = triangleService.doCalculation(triangle);

			return output.printResponce("The area of triangle = ", Double.toString(area))
					+ output.printResponce("The height of triangle = ", Double.toString(height))
					+ output.printResponce("The radius of circumscribed circle = ", Double.toString(radiusOut))
					+ output.printResponce("The radius of inscribed circle = ", Double.toString(radiusIn));

		} catch (NumberFormatException e) {
			LOGGER.error("wrong format of args");
			return output.print("Incorrect input: incorrect format of numbers");

		} catch (IllegalArgumentException e) {
			LOGGER.error("negative or o");
			return output.print("Incorrect input: number should be positive and can not be equal to 0");
		}
	}
}