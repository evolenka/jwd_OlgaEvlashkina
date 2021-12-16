package by.jwd.task02array.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task02array.view.Input;
import by.jwd.task02array.view.Output;

public class Runner {

	static Logger logger = LogManager.getLogger(Runner.class);

	public static void main(String[] args) {

		Output output = new Output();
		Input input = new Input();

		CommandProvider provider = new CommandProvider();
		Command command;

		output.showMenu();
		output.print("Please choose the respective command (1, 2, 3 ... or 10)\n>>");

		try {
			String commandName = input.read();
			command = provider.getCommand(commandName);
			command.execute();
		} catch (IOException e) {
			output.print("Incorrect input");
		}
	}
}