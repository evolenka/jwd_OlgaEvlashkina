package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.service.PasswordService;
import by.jwd.task01basic.service.impl.AccessByPasswordServiceImpl;
import by.jwd.task01basic.view.Output;

public class AccessByPasswordControllerImpl implements Command {

	Output output = new Output();
	PasswordService service = new AccessByPasswordServiceImpl();;

	@Override
	public String execute(String[] params) {

		String result;

		result = service.getInfo(params[0]);
		return output.printResponce("", result);
	}
}