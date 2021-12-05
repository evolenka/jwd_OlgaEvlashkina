package by.jwd.task01basic.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.service.RectangleService;
import by.jwd.task01basic.service.ServiceException;
import by.jwd.task01basic.view.Output;

public class RectangleAreaCommandImpl implements Command {

	static Logger logger = LogManager.getLogger(RectangleAreaCommandImpl.class);

	private RectangleService rectangleService;
	private Rectangle rectangle;

	public RectangleAreaCommandImpl(RectangleService rectangleService, Rectangle rectangle) {
		this.rectangleService = rectangleService;
		this.rectangle = rectangle;
	}

	@Override
	public void execute() {
		
		Output output = new Output();
		
		try {
			double result = rectangleService.doCalculation(rectangle);
			output.showResponce("The rectangle area =  " + Double.toString(result));
			
		} catch (ServiceException e) {
			logger.error("negative number (or = 0)");
			output.showMessage("Incorrect input:  number(s) should be positive");
		}
	}
}