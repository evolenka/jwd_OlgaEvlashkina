package by.jwd.task02array.controller;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

	private Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put("1", new BubbleSortCommandImpl());
		commands.put("2", new InsertionSortCommandImpl());
		commands.put("3", new SelectionSortCommandImpl());
		commands.put("4", new ShakerSortCommandImpl());
		commands.put("5", new ShellSortCommandImpl());
		commands.put("6", new TwoWayMergeSortCommandImpl());
		commands.put("7", new InsertionSortByAddressCommandImpl());
		commands.put("8", new ExternalSortCommandImpl());
		commands.put("wrongRequest", new WrongRequestImpl());
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
