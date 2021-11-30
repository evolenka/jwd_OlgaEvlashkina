package by.jwd.task01basic.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticIntegerService;
import by.jwd.task01basic.service.impl.QuantityOfPositiveNumberServiceImpl;
import by.jwd.task01basic.view.Output;

public class QuantityOfPositiveNumberControllerImpl implements Command {

	Output output = new Output();
	ArithmeticIntegerService service = new QuantityOfPositiveNumberServiceImpl();
	NumberData<Integer> numberData = new NumberData<>();
	
	static Logger LOGGER = LogManager.getLogger(DoesBrickFitRectangleControllerImpl.class);

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
			LOGGER.error("wrong format of args");
			return output.print("Incorrect input: wrong format of numbers");

		} catch (IllegalArgumentException e) {
			LOGGER.error("negative number");
			return output.print("Incorrect input: number should be natural(more than 0)");

		} catch (ArrayIndexOutOfBoundsException e) {
			LOGGER.error("wrong quantity of args");
			return output.print("Incorrect input: three numbers are requested");
		}
	}
}
