package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticDoubleService;
import by.jwd.task01basic.view.Output;

public class AbsValueOfExpressionCommandImpl implements Command {

	private ArithmeticDoubleService service;
	private NumberData<Double> numberData;

	public AbsValueOfExpressionCommandImpl(ArithmeticDoubleService service, NumberData<Double> numberData) {
		this.service = service;
		this.numberData = numberData;
	}

	@Override
	public void execute() {
		
		Output output = new Output();
		
		double result = service.calculate(numberData);
		
		output.showResponce("The absolute value of the expression =  " + Double.toString(result));
	}
}