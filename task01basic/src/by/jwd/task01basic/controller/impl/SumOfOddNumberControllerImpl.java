package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.service.impl.SumOfOddNumberService;
import by.jwd.task01basic.view.Output;

public class SumOfOddNumberControllerImpl implements Command {

	Output output = new Output();
	SumOfOddNumberService service = new SumOfOddNumberService();

	@Override
	public String execute(String[] params) {

		int result;

		result = service.sumOfOddNumbers();
		return output.printResponce("The sum of odd numbers from 1 to 99 =  ", Integer.toString(result));
	}
}