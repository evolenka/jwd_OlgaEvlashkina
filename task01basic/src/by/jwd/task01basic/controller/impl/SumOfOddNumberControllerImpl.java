package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.impl.SumOfOddNumberServiceImpl;
import by.jwd.task01basic.view.Output;

public class SumOfOddNumberControllerImpl implements Command {

	private SumOfOddNumberServiceImpl service;
	private NumberData<Integer> numberdata;

	public SumOfOddNumberControllerImpl(SumOfOddNumberServiceImpl service, NumberData<Integer> numberdata) {

		this.service = service;
		this.numberdata = numberdata;
	}

	@Override
	public void execute() {

		Output output = new Output();

		int result = service.calculate(numberdata);

		output.showResponce("The sum of odd numbers from 1 to 99 =  " + Integer.toString(result));
		
	}
}