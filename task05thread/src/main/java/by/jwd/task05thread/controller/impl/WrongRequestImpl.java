package by.jwd.task05thread.controller.impl;

import by.jwd.task05thread.controller.Command;
import by.jwd.task05thread.view.MessageManager;
import by.jwd.task05thread.view.Output;

public class WrongRequestImpl implements Command {

	@Override
	public <T extends Number & Comparable<T>> void execute(MessageManager current, String[] param) {

		Output view = new Output();
		view.print(Thread.currentThread().getName() + ": " + current.getString("err1"));
	}
}
