package by.jwd.task03polymorphism.controller;

import by.jwd.task03polymorphism.view.MessageManager;

public interface Command {
	

	public void execute(MessageManager current, String [][] param);


}
