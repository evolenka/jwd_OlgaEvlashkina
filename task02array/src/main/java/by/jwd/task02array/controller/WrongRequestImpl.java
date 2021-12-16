package by.jwd.task02array.controller;

import by.jwd.task02array.view.Output;

public class WrongRequestImpl implements Command{
	
	//Output view = new Output();

	@Override 
	public void execute () {
	Output view = new Output();
	
	view.print("Wrong command");

	}
}
