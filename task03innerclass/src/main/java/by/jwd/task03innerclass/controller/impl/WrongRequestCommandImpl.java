package by.jwd.task03innerclass.controller.impl;

import by.jwd.task03innerclass.controller.Command;
import by.jwd.task03innerclass.view.MessageManager;
import by.jwd.task03innerclass.view.Output;

public class WrongRequestCommandImpl implements Command {

	@Override
	public void execute(MessageManager current, String[] param) {

		Output view = new Output();

		view.print(current.getString("err1"));
	}
}