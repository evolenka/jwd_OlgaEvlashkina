package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.view.IoData;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.service.ConvertToCharService;
import by.jwd.task01basic.service.ConvertToIntService;
import by.jwd.task01basic.service.impl.ConvertToCharServiceImpl;
import by.jwd.task01basic.service.impl.ConvertToIntServiceImpl;

public class CharOperationsControllerImpl implements Command {
	IoData iodata = new IoData();
	ConvertToIntService convertToInt = new ConvertToIntServiceImpl();
	ConvertToCharService convertToChar = new ConvertToCharServiceImpl();

	@Override
	public String execute(String[] params) {

		int index = convertToInt.doAction(params[0].charAt(0));
		char result[] = convertToChar.doAction(index);

		if (result[0] == '0') {
			return iodata.printResponce("The index of your character - ", Integer.toString(index))
					+ iodata.print("The next character - no")
					+ iodata.printResponce("The previous character  - ", Character.toString(result[1]));

		} else if (result[1] == '0') {
			return iodata.printResponce("The index of your character - ", Integer.toString(index))
					+ iodata.printResponce("The next character  - ", Character.toString(result[0]))
					+ iodata.print("The previous character - no");

		} else {
			return iodata.printResponce("The index of your character - ", Integer.toString(index))
					+ iodata.printResponce("The next character - ", Character.toString(result[0]))
					+ iodata.printResponce("The previous character  - ", Character.toString(result[1]));
		}
	}
}