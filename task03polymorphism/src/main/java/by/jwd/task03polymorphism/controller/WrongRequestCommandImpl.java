package by.jwd.task03polymorphism.controller;

import by.jwd.task03polymorphism.view.MessageManager;
import by.jwd.task03polymorphism.view.Output;

public class WrongRequestCommandImpl implements Command {

	@Override
	public void execute(MessageManager current, String[][] param) {

		Output view = new Output();

		view.print(current.getString("err1"));
	}
}
