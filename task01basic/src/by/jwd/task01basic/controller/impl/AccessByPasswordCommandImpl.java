package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.service.PasswordService;
import by.jwd.task01basic.view.Output;

public class AccessByPasswordCommandImpl implements Command {

	private PasswordService service;
	private String password;

	public AccessByPasswordCommandImpl(PasswordService service, String password) {
		this.service = service;
		this.password = password;
	}

	@Override
	public void execute() {
		
		Output output = new Output();

		String result = service.getInfo(password);
		
		output.showResponce(result);
	}
}