package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticDoubleService;
import by.jwd.task01basic.service.impl.AbsValueOfExpressionServiceImpl;
import by.jwd.task01basic.view.Output;

public class AbsValueOfExpressionControllerImpl implements Command {

	Output output = new Output();
	ArithmeticDoubleService service = new AbsValueOfExpressionServiceImpl();
	NumberData<Double> numberData = new NumberData<>();

	@Override
	public String execute(String[] params) {

		double result;

		try {
			numberData.addNumberData(Double.parseDouble(params[0]));
			numberData.addNumberData(Double.parseDouble(params[1]));
			numberData.addNumberData(Double.parseDouble(params[2]));
			numberData.addNumberData(Double.parseDouble(params[3]));

			result = service.calculate(numberData);
			return output.printResponce("The absolute value of this expression =  ", Double.toString(result));

		} catch (NumberFormatException e) {
			return output.print("Incorrect input: wrong format of numbers");
		}

		catch (ArrayIndexOutOfBoundsException e) {
			return output.print("Incorrect input: four numbers are requested");
		}
	}
}