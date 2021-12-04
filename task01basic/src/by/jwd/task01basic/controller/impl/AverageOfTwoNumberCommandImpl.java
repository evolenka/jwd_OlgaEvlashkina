package by.jwd.task01basic.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticDoubleService;
import by.jwd.task01basic.view.Output;

public class AverageOfTwoNumberCommandImpl implements Command {

	static Logger LOGGER = LogManager.getLogger(AverageOfTwoNumberCommandImpl.class);

	private ArithmeticDoubleService service;
	private NumberData<Double> numberData;

	public AverageOfTwoNumberCommandImpl(ArithmeticDoubleService service, NumberData<Double> numberData) {
		this.service = service;
		this.numberData = numberData;
	}

	@Override
	public void execute() {
		Output output = new Output();
		
		double result = service.calculate(numberData);
		
		output.showResponce("The average of two numbers =  " + Double.toString(result));
	}
}
