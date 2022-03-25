package by.jwd.task01basic.controller.impl;

import java.util.List;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.GuessNumberService;
import by.jwd.task01basic.service.impl.GuessNumberServiceImpl;
import by.jwd.task01basic.view.Output;

public class GuessNumberCommandImpl implements Command {

	private GuessNumberService service = new GuessNumberServiceImpl();
	private NumberData<Integer> numberData = new NumberData<>();

	public GuessNumberCommandImpl(GuessNumberService service, NumberData<Integer> numberData) {
		this.service = service;
		this.numberData = numberData;
	}

	@Override
	public void execute() {

		Output output = new Output();

		List<NumberData<Integer>> result = service.guess(numberData);

		output.showResponce("Guessed numbbers:  " + result.get(0).getNumberData().toString() + "\nUnguessed numbers: "
				+ result.get(1).getNumberData().toString() + "\nMistaken numbers:"
				+ result.get(2).getNumberData().toString());
	}
}