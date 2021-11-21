package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.RectangleService;
import by.jwd.task01basic.service.TriangleService;
import by.jwd.task01basic.service.impl.RectangleSquareImpl;
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
	public String execute(String[] params) {

		try {
			if (params[0].equals("1")) {
				double length = Double.parseDouble(params[1]);
				double width = length / 2;
				Rectangle rectangle = new Rectangle(length, width);

				rectangleService = new RectangleSquareImpl();
				double result = rectangleService.doCalculation(rectangle);
				return iodata.printResponce("The rectangle square =  ", Double.toString(result));

			} else  {

				int length = Integer.parseInt(params[1]);
				Triangle triangle = new Triangle(length, length, length);

				triangleService = new TriangleAreaImpl();
				double area = triangleService.doCalculation(triangle);

				triangleService = new TriangleHeightImpl();
				double hight = triangleService.doCalculation(triangle);

				triangleService = new TriangleRadiusInImpl();
				double radiusIn = triangleService.doCalculation(triangle);

				triangleService = new TriangleRadiusOutImpl();
				double radiusOut = triangleService.doCalculation(triangle);

				return iodata.printResponce("The area of triangle = ", Double.toString(area))
						+ iodata.printResponce("The height of triangle = ", Double.toString(hight))
						+ iodata.printResponce("The radius of circumscribed circle = ", Double.toString(radiusOut))
						+ iodata.printResponce("The radius of inscribed circle = ", Double.toString(radiusIn));
			}
		} catch (NumberFormatException e) {
			return iodata.print("Incorrect format of numbers");
		}
	}
}