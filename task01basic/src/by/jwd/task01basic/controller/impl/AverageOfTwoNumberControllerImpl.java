package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticDoubleService;
import by.jwd.task01basic.service.impl.AverageOfTwoNumberServiceImpl;
import by.jwd.task01basic.view.Output;

public class AverageOfTwoNumberControllerImpl implements Command {

	Output output = new Output();
	ArithmeticDoubleService service = new AverageOfTwoNumberServiceImpl () ;
	NumberData<Double> numberData = new NumberData<>();

	@Override
	public String execute(String[] params) {

		double result;

		try {
			numberData.addNumberData(Double.parseDouble(params[0]));
			numberData.addNumberData(Double.parseDouble(params[1]));
			
			result = service.calculate(numberData);
			return output.printResponce("The average of two numbers =  ", Double.toString(result));

		} catch (NumberFormatException e) {
			return output.print("Incorrect input: wrong format of numbers");
		}

		catch (ArrayIndexOutOfBoundsException e) {
			return output.print("Incorrect input: two numbers are requested");
		}
	}
}