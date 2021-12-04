package by.jwd.task01basic.controller;

public class Provider {

	private Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}

	public void executeCommand () {
		command.execute();
	}

}
