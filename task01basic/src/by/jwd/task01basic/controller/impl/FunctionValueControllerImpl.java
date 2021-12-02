package by.jwd.task01basic.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.FunctionValueService;
import by.jwd.task01basic.service.impl.FunctionValueServiceImpl;
import by.jwd.task01basic.view.Output;

public class FunctionValueControllerImpl implements Command {

	Output output = new Output();
	FunctionValueService service = new FunctionValueServiceImpl();
	NumberData<Double> numberData = new NumberData<>();
	
	static Logger LOGGER = LogManager.getLogger(FunctionValueControllerImpl.class);

	@Override
	public String execute(String[] params) {

		NumberData<Double> result;

		try {
			numberData.addNumberData(Double.parseDouble(params[0]));
			numberData.addNumberData(Double.parseDouble(params[1]));
			numberData.addNumberData(Double.parseDouble(params[2]));

			result = service.findFunctionValue(numberData);
			return output.printResponce("Tne values of function on the given segment are",
					result.getNumberData().toString());

		} catch (NumberFormatException e) {
			return output.print("Incorrect input: wrong format of numbers");
		}

		catch (ArrayIndexOutOfBoundsException e) {
			return output.print("Incorrect input: three numbers are requested");
		}
	}
}