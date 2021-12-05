package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.FunctionValueService;
import by.jwd.task01basic.view.Output;

public class FunctionValueCommandImpl implements Command {

	private FunctionValueService service;
	private NumberData<Double> numberData;

	public FunctionValueCommandImpl(FunctionValueService service, NumberData<Double> numberData) {
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