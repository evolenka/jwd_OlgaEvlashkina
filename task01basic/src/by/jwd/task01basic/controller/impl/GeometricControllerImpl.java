package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.RectangleService;
import by.jwd.task01basic.service.TriangleService;
import by.jwd.task01basic.service.impl.RectangleAreaImpl;
import by.jwd.task01basic.service.impl.TriangleHeightImpl;
import by.jwd.task01basic.service.impl.TriangleRadiusInImpl;
import by.jwd.task01basic.service.impl.TriangleRadiusOutImpl;
import by.jwd.task01basic.service.impl.TriangleAreaImpl;
import by.jwd.task01basic.view.IoData;

public class GeometricControllerImpl implements Command {

	IoData iodata = new IoData();
	RectangleService rectangleService;
	TriangleService triangleService;

	@Override
	public String execute(String[] params) throws IllegalArgumentException {

		try {
			double length = Double.parseDouble(params[1]);
			if (length <= 0) {
				throw new IllegalArgumentException();
			}

			if (params[0].equals("1")) {

				double width = length / 2;

				Rectangle rectangle = new Rectangle(length, width);

				rectangleService = new RectangleAreaImpl();

				double result = rectangleService.doCalculation(rectangle);
				return iodata.printResponce("The rectangle area =  ", Double.toString(result));

			} else {

				Triangle triangle = new Triangle(length, length, length);

				triangleService = new TriangleAreaImpl();
				double area = triangleService.doCalculation(triangle);

				triangleService = new TriangleHeightImpl();
				double height = triangleService.doCalculation(triangle);

				triangleService = new TriangleRadiusInImpl();
				double radiusIn = triangleService.doCalculation(triangle);

				triangleService = new TriangleRadiusOutImpl();
				double radiusOut = triangleService.doCalculation(triangle);

				return iodata.printResponce("The area of triangle = ", Double.toString(area))
						+ iodata.printResponce("The height of triangle = ", Double.toString(height))
						+ iodata.printResponce("The radius of circumscribed circle = ", Double.toString(radiusOut))
						+ iodata.printResponce("The radius of inscribed circle = ", Double.toString(radiusIn));
			}

		} catch (NumberFormatException e) {
			return iodata.print("Incorrect input: incorrect format of numbers");

		} catch (IllegalArgumentException e) {
			return iodata.print("Incorrect input: number should be positive and can not be equal to 0");
		}
	}
}