package by.jwd.task01basic.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.impl.SwapExtraTaskService;
import by.jwd.task01basic.view.Output;

public class SwapExtraTaskControllerImpl implements Command {

	Output output = new Output();
	SwapExtraTaskService service = new SwapExtraTaskService();
	NumberData<Integer> numberData = new NumberData<>();

	static Logger LOGGER = LogManager.getLogger(GuessNumberControllerImpl.class);

	@Override
	public String execute(String[] params) {

		NumberData<Integer> result1;
		NumberData<Integer> result2;
		NumberData<Integer> result3;

		try {
			numberData.addNumberData(Integer.parseInt(params[0]));
			numberData.addNumberData(Integer.parseInt(params[1]));

			result1 = service.swapFirstMethod(numberData);
			result2 = service.swapSecondMethod(result1);
			result3 = service.swapThirdMethod(result2);

			return output.printResponce("Numbers after first swap:  a = ",
					result1.getNumberData().get(0).toString() + "; b = " + result1.getNumberData().get(1).toString())
					+ output.printResponce("\nNumbers after second swap:  a = ",
							result2.getNumberData().get(0).toString() + "; b = "
									+ result2.getNumberData().get(1).toString())
					+ output.printResponce("\nNumbers after third swap:  a = ",
							result3.getNumberData().get(0).toString() + "; b = "
									+ result3.getNumberData().get(1).toString());

		} catch (NumberFormatException e) {
			LOGGER.error("wrong format of args");
			return output.print("Incorrect input: wrong format of numbers");
		}

		catch (ArrayIndexOutOfBoundsException e) {
			LOGGER.error("wrong quantity of args");
			return output.print("Incorrect input: two numbers are requested");
		}
	}
}