package by.jwd.task02array.controller;

import by.jwd.task02array.view.MessageManager;
import by.jwd.task02array.view.Output;

public class WrongRequestImpl implements Command {

	@Override
	public void execute(MessageManager current) {
		Output view = new Output();

		view.print(current.getString("err1"));
	}
}
