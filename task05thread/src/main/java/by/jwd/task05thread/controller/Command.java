package by.jwd.task05thread.controller;

import by.jwd.task05thread.view.MessageManager;

public interface Command {

	public <T extends Number & Comparable <T>> void execute(MessageManager current, String[] param);
}
