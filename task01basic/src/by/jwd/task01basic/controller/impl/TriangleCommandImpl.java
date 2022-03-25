package by.jwd.task01basic.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.ServiceException;
import by.jwd.task01basic.service.TriangleService;
import by.jwd.task01basic.view.Output;

public class TriangleCommandImpl implements Command {

	static Logger logger = LogManager.getLogger(TriangleCommandImpl.class);

	private TriangleService areaService;
	private TriangleService heightService;
	private TriangleService radiusInService;
	private TriangleService radiusOutService;
	private Triangle triangle;

	public TriangleCommandImpl(TriangleService areaService, TriangleService heightService,
			TriangleService radiusInService, TriangleService radiusOutService, Triangle triangle) {

		this.areaService = areaService;
		this.heightService = heightService;
		this.radiusInService = radiusInService;
		this.radiusOutService = radiusOutService;
		this.triangle = triangle;
	}

	@Override
	public void execute() {

		Output output = new Output();
		
		try {
			// areaService = new TriangleAreaServiceImpl();
			double area = areaService.doCalculation(triangle);

			// heightService = new TriangleHeightServiceImpl();
			double height = heightService.doCalculation(triangle);

			// radiusInService = new TriangleRadiusInServiceImpl();
			double radiusIn = radiusInService.doCalculation(triangle);

			// radiusOutService = new TriangleRadiusOutServiceImpl();
			double radiusOut = radiusOutService.doCalculation(triangle);

			output.showResponce("The area of triangle = " + Double.toString(area) + "\nThe height of triangle = "
					+ Double.toString(height) + "\nThe radius of circumscribed circle = " + Double.toString(radiusOut)
					+ "\nThe radius of inscribed circle = " + Double.toString(radiusIn));

		} catch (ServiceException e) {
			logger.error("negative number (or = 0)");
			output.showMessage("Incorrect input:  number(s) should be positive");
		}
	}
}