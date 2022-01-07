package by.jwd.task03innerclass.controller;

import by.jwd.task03innerclass.view.MessageManager;

public interface Command {

	public void execute(MessageManager current, String [] param);
}