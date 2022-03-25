package by.jwd.task06infohandling.controller.impl;

import by.jwd.task06infohandling.controller.Command;
import by.jwd.task06infohandling.view.Output;

public class WrongRequestCommandImpl implements Command {

	@Override
	public void execute(String[] param) {

		Output view = new Output();
		view.print("wrong command");
	}
}