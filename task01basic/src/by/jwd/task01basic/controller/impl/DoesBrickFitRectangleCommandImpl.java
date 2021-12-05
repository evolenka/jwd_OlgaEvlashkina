package by.jwd.task01basic.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.service.RectangleLogicService;
import by.jwd.task01basic.service.ServiceException;
import by.jwd.task01basic.view.Output;

public class DoesBrickFitRectangleCommandImpl implements Command {

	static Logger logger = LogManager.getLogger(DoesBrickFitRectangleCommandImpl.class);

	private RectangleLogicService service;
	private NumberData<Double> numberData;
	private Rectangle rectangle;

	public DoesBrickFitRectangleCommandImpl(RectangleLogicService service, NumberData<Double> numberData,
			Rectangle rectangle) {
		this.service = service;
		this.numberData = numberData;
		this.rectangle = rectangle;
	}

	@Override
	public void execute() {

		Output output = new Output();
		try {
			boolean result = service.doLogic(rectangle, numberData);

			if (result) {
				output.showResponce("The brick fits the rectangle hole");
			} else
				output.showResponce("The brick does not fit the rectangle hole");

		} catch (ServiceException e) {
			logger.error("negative number (or = 0)");
			output.showMessage("Incorrect input:  number(s) should be positive");
		}
	}
}