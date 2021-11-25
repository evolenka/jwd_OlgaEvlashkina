package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticService;
import by.jwd.task01basic.service.impl.ArithmeticServiceImpl;
import by.jwd.task01basic.view.IoData;

public class ArithmeticControllerImpl implements Command {
	IoData iodata = new IoData();
	ArithmeticService arithmeticservice = new ArithmeticServiceImpl();

	@Override
	public String execute(String[] params) {

		NumberData numberData = new NumberData();
		double result;
		try {
			numberData.addNumberData(Integer.parseInt(params[0]));
			numberData.addNumberData(Integer.parseInt(params[1]));
			result = arithmeticservice.calculate(numberData);
			return iodata.printResponce("The average of two numbers =  ", Double.toString(result));

		} catch (NumberFormatException e) {
			return iodata.print("Incorrect input: wrong format of numbers");
		}

		catch (ArrayIndexOutOfBoundsException e) {
			return iodata.print("Incorrect input: two numbers are requested");
		}
	}
}