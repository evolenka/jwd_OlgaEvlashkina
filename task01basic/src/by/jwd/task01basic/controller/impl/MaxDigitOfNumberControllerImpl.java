package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticIntegerService;
import by.jwd.task01basic.service.impl.MaxDigitOfNumberServiceImpl;
import by.jwd.task01basic.view.Output;

public class MaxDigitOfNumberControllerImpl implements Command {

	Output output = new Output();
	ArithmeticIntegerService service = new MaxDigitOfNumberServiceImpl();;
	NumberData<Integer> numberData = new NumberData<>();

	@Override
	public String execute(String[] params) {

		int result;

		try {
			int number = Integer.parseInt(params[0]);

			if (number <= 0) {
				throw new IllegalArgumentException();
			}

			numberData.addNumberData(number);
		
			result = service.calculate(numberData);
			return output.printResponce("The max digit in the given number =  ", Integer.toString(result));

		} catch (NumberFormatException e) {
			return output.print("Incorrect input: wrong format of numbers");

		} catch (IllegalArgumentException e) {
			return output.print("Incorrect input: number should be natural(more than 0)");
		}
	}
}