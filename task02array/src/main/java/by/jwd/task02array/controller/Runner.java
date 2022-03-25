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
		MessageManager current = MessageManager.EN;

		output.print("1 — eng\n2 — rus\nany — default");

		try {
			String language = input.read();

			switch (language) {
			case "1":
				current = MessageManager.EN;
				break;
			case "2":
				current = MessageManager.RU;
				break;
			default:
				current = MessageManager.EN;
			}

			CommandProvider provider = new CommandProvider();
			Command command;

			output.print(current.getString("menu"));
			output.print(current.getString("request1"));

			String commandName = input.read();
			if (commandName.equals("9") || commandName.equals("10")) {
				output.print(current.getString("request3"));
			} else {
				output.print(current.getString("request2"));
			}
			String[] param = input.read().split("\\s+");

			command = provider.getCommand(commandName);
			command.execute(current, param);
		} catch (IOException e) {
			output.print(current.getString("err3"));
			logger.error("Incorrect input");
		}
	}
}