package by.jwd.task01basic.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.FunctionValueService;
import by.jwd.task01basic.view.Output;

public class FunctionValueControllerImpl implements Command {

	static Logger logger = LogManager.getLogger(FunctionValueControllerImpl.class);

	private FunctionValueService service;
	private NumberData<Double> numberData;

	public FunctionValueControllerImpl(FunctionValueService service, NumberData<Double> numberData) {
		this.service = service;
		this.numberData = numberData;
	}

	@Override
	public void execute() {
		
		Output output = new Output();

		NumberData<Double> result = service.findFunctionValue(numberData);

		output.showResponce("Tne values of function on the given segment are" + result.getNumberData().toString());
	}
}