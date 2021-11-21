package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.view.IoData;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.Text;
import by.jwd.task01basic.service.TextOperationService;
import by.jwd.task01basic.service.impl.TextOperationServiceImpl;

public class TextOperationControllerImpl implements Command {
	IoData iodata = new IoData();
	TextOperationService textOperatioService = new TextOperationServiceImpl();

	@Override
	public String execute(String[] params) {

		Text sequence = new Text(new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
				"o", "p", "r", "s", " t", "u", "v", "w", "x", "y", "z" });

		String[] result = textOperatioService.doAction(sequence, params[0]);

		if (result[0].equals("-1")) {
			return iodata.print("No such character in the given range");
		} else {
			return iodata.printResponce("The index of your character - ", result[0])
					+ iodata.printResponce("The next character - ", result[1])
					+ iodata.printResponce("The previous character  - ", result[2]);
		}
	}
}