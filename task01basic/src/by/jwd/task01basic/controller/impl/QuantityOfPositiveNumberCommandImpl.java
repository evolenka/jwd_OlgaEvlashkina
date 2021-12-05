package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.impl.QuantityOfPositiveNumberServiceImpl;
import by.jwd.task01basic.view.Output;

public class QuantityOfPositiveNumberCommandImpl implements Command {

	private QuantityOfPositiveNumberServiceImpl service;
	private NumberData<Integer> numberData;

	public QuantityOfPositiveNumberCommandImpl(QuantityOfPositiveNumberServiceImpl service,
			NumberData<Integer> numberData) {
		this.service = service;
		this.numberData = numberData;
	}

	@Override
	public void execute() {

		Output output = new Output();

		int result = service.calculate(numberData);

		output.showResponce("The quantity of positive numbers =  " + Integer.toString(result));
	}
}