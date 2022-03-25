package by.jwd.task03innerclass.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03innerclass.view.Input;
import by.jwd.task03innerclass.view.MessageManager;
import by.jwd.task03innerclass.view.Output;

/*13.—оздать класс Shop с внутренним классом, с помощью объектов которого
можно хранить информацию об отделах, товарах и услугах.*/

public class Runner {

	static Logger logger = LogManager.getLogger(Runner.class);

	public static void main(String[] args) {

		Output output = new Output();
		Input input = new Input();
		MessageManager current = MessageManager.EN;

		output.print("1 Ч eng\n2 Ч rus\nany Ч default");

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

			String[] param = new String[2];

			output.print(current.getString("request2"));
			param[0] = input.read();

			if (commandName.equals("3")) {
				output.print(current.getString("request3"));
				param[1] = input.read();
			}

			if (commandName.equals("4")) {
				output.print(current.getString("request4"));
				param[1] = input.read();
			}

			command = provider.getCommand(commandName);
			command.execute(current, param);
			
		} catch (IOException e) {
			output.print(current.getString("err2"));
			logger.error("Incorrect input");
		} catch (IllegalArgumentException e) {
			output.print(current.getString("err3"));
			logger.error("Wrong quantity of args");
		}
	}
}
