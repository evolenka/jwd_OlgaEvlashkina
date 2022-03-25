package by.jwd.task02array.controller;

import by.jwd.task02array.view.MessageManager;

public interface Command {

	public void execute(MessageManager current, String [] param);
}
