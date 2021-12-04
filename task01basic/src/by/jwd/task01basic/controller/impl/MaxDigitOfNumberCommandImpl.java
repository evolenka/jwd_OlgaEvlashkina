package by.jwd.task01basic.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.ArithmeticIntegerService;
import by.jwd.task01basic.service.impl.ServiceException;
import by.jwd.task01basic.view.Output;

public class MaxDigitOfNumberCommandImpl implements Command {

	static Logger logger = LogManager.getLogger(MaxDigitOfNumberCommandImpl.class);

	private ArithmeticIntegerService service;
	private NumberData<Integer> numberData;

	public MaxDigitOfNumberCommandImpl(ArithmeticIntegerService service, NumberData<Integer> numberData) {

		this.service = service;
		this.numberData = numberData;
	}

	@Override
	public void execute() {

		Output output = new Output();
		try {

			int result = service.calculate(numberData);

			output.showResponce("The max digit in the given number =  " + Integer.toString(result));
			
		} catch (ServiceException e) {
			logger.error("negative number (or = 0)");
			output.showMessage("Incorrect input:  number should be positive");
		}
	}
}