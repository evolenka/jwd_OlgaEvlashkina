package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticIntegerService;
import by.jwd.task01basic.service.impl.QuantityOfPositiveNumberServiceImpl;
import by.jwd.task01basic.view.Output;

public class QuantityOfPositiveNumberControllerImpl implements Command {

	Output output = new Output();
	ArithmeticIntegerService service = new QuantityOfPositiveNumberServiceImpl();
	NumberData<Integer> numberData = new NumberData<>();

	@Override
	public String execute(String[] params) {

		int result;

		try {
			numberData.addNumberData(Integer.parseInt(params[0]));
			numberData.addNumberData(Integer.parseInt(params[1]));
			numberData.addNumberData(Integer.parseInt(params[2]));

			result = service.calculate(numberData);
			return output.printResponce("The quantity of positive numbers =  ", Integer.toString(result));

		} catch (NumberFormatException e) {
			return output.print("Incorrect input: wrong format of numbers");

		} catch (IllegalArgumentException e) {
			return output.print("Incorrect input: number should be natural(more than 0)");

		} catch (ArrayIndexOutOfBoundsException e) {
			return output.print("Incorrect input: three numbers are requested");
		}
	}
}
