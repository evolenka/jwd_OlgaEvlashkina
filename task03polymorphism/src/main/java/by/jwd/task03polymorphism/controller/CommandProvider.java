package by.jwd.task03polymorphism.controller;

import java.util.HashMap;
import java.util.Map;


public class CommandProvider {
	
	private Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put("1", new SortByPriceCommandImpl());
		commands.put("2", new SortByNetWeightCommandImpl());
		commands.put("3", new SortByRatioCommandImpl());
		commands.put("4", new FindByParameterCommandImpl());
		commands.put("wrongRequest", new WrongRequestCommandImpl());
	}

	public Command getCommand(String commandName) {
		Command command;
		try {
			command = commands.get(commandName);
			if (command == null) {
				throw new NullPointerException();
			}
		} catch (IllegalArgumentException | NullPointerException e) {
			command = commands.get("wrongRequest");
		}
		return command;
	}
}