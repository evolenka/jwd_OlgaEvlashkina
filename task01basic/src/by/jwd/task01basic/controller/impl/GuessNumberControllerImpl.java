package by.jwd.task01basic.controller.impl;

import java.util.List;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.GuessNumberService;
import by.jwd.task01basic.service.impl.GuessNumberServiceImpl;
import by.jwd.task01basic.view.Output;

public class GuessNumberControllerImpl implements Command {

	Output output = new Output();
	GuessNumberService service = new GuessNumberServiceImpl();
	NumberData<Integer> numberData = new NumberData<>();

	@Override
	public String execute(String[] params) {

		List<NumberData<Integer>> result;

		try {
			numberData.addNumberData(Integer.parseInt(params[0]));
			numberData.addNumberData(Integer.parseInt(params[1]));
			numberData.addNumberData(Integer.parseInt(params[2]));
			numberData.addNumberData(Integer.parseInt(params[3]));
			numberData.addNumberData(Integer.parseInt(params[4]));

			result = service.doAction(numberData);
			return output.printResponce("Guessed numbbers:  ",
					result.get(0).getNumberData().toString() + "\nUnguessed numbers: "
							+ result.get(1).getNumberData().toString() + "\nMistaken numbers:"
							+ result.get(2).getNumberData().toString());

		} catch (NumberFormatException e) {
			return output.print("Incorrect input: wrong format of numbers");
		}

		catch (ArrayIndexOutOfBoundsException e) {
			return output.print("Incorrect input: five numbers are requested");
		}
	}
}