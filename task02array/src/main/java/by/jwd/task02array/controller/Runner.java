package by.jwd.task02array.controller;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task02array.view.Input;
import by.jwd.task02array.view.MessageManager;
import by.jwd.task02array.view.Output;


public class Runner {

	static Logger logger = LogManager.getLogger(Runner.class);

	public static void main(String[] args) {
		Output output = new Output();
		Input input = new Input();

		output.print("1 — eng\n2 — rus\nany — default");

		String i = null;
		try {
			i = input.read();
		} catch (IOException e) {
			logger.error("Incorrect input");
			output.print("Incorrect input");
		}

		MessageManager current = MessageManager.EN;

		switch (i) {
		case "1":
			current = MessageManager.EN;
			break;
		case "2":
			current = MessageManager.RU;
			break;
		}

		CommandProvider provider = new CommandProvider();
		Command command;

		output.print(current.getString("menu"));
		output.print(current.getString("request"));

		try {
			String commandName = input.read();
			command = provider.getCommand(commandName);
			command.execute(current);
		} catch (IOException e) {
			output.print("Incorrect input");
		}
	}
}