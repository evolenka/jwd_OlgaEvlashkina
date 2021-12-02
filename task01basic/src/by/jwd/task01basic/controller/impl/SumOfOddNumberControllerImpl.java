package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.impl.SumOfOddNumberServiceImpl;
import by.jwd.task01basic.view.Output;

public class SumOfOddNumberControllerImpl implements Command {

	Output output = new Output();
	SumOfOddNumberServiceImpl service = new SumOfOddNumberServiceImpl();
	NumberData<Integer> numberdata = new NumberData<>();

	@Override
	public String execute(String[] params) {

		int result;

		for (int i = 0; i < 100; i++) {
			numberdata.addNumberData(i);
		}
		result = service.calculate(numberdata);
		return output.printResponce("The sum of odd numbers from 1 to 99 =  ", Integer.toString(result));
	}
}