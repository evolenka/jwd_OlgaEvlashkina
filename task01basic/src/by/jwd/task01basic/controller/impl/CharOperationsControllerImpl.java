package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.view.Output;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.service.ConvertToCharService;
import by.jwd.task01basic.service.ConvertToIntService;
import by.jwd.task01basic.service.impl.ConvertToCharServiceImpl;
import by.jwd.task01basic.service.impl.ConvertToIntServiceImpl;

public class CharOperationsControllerImpl implements Command {

	Output output = new Output();
	ConvertToIntService convertToInt = new ConvertToIntServiceImpl();
	ConvertToCharService convertToChar = new ConvertToCharServiceImpl();

	@Override
	public String execute(String[] params) {

		int index = convertToInt.doAction(params[0].charAt(0));
		char[] result = convertToChar.doAction(index);

		output.printResponce("The index of your character - ", Integer.toString(index));

		if (result[0] == '0') {
			return output.print("The next character - no")
					+ output.printResponce("The previous character  - ", Character.toString(result[1]));

		} else if (result[1] == '0') {
			return output.printResponce("The next character  - ", Character.toString(result[0]))
					+ output.print("The previous character - no");

		} else {
			return output.printResponce("The next character - ", Character.toString(result[0]))
					+ output.printResponce("The previous character  - ", Character.toString(result[1]));
		}
	}
}