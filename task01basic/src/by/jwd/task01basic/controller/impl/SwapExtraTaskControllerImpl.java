package by.jwd.task01basic.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.impl.SwapExtraTaskService;
import by.jwd.task01basic.view.Output;

public class SwapExtraTaskControllerImpl implements Command {

	static Logger LOGGER = LogManager.getLogger(GuessNumberControllerImpl.class);

	private SwapExtraTaskService service;
	private NumberData<Integer> numberData;

	public SwapExtraTaskControllerImpl(SwapExtraTaskService service, NumberData<Integer> numberData) {

		this.service = service;
		this.numberData = numberData;
	}

	@Override
	public void execute() {

		Output output = new Output();

		NumberData<Integer> result1;
		NumberData<Integer> result2;
		NumberData<Integer> result3;

		result1 = service.swapFirstMethod(numberData);
		result2 = service.swapSecondMethod(result1);
		result3 = service.swapThirdMethod(result2);

		output.showResponce("Numbers after first swap:  a = " + result1.getNumberData().get(0).toString() + "; b = "
				+ result1.getNumberData().get(1).toString() + "\nNumbers after second swap:  a = "
				+ result2.getNumberData().get(0).toString() + "; b = " + result2.getNumberData().get(1).toString()
				+ "\nNumbers after third swap:  a = " + result3.getNumberData().get(0).toString() + "; b = "
				+ result3.getNumberData().get(1).toString());

	}
}