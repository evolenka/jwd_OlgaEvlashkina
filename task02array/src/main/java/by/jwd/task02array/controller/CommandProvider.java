package by.jwd.task02array.controller;

import java.util.HashMap;
import java.util.Map;

import by.jwd.task02array.controller.impl.BubbleSortCommandImpl;
import by.jwd.task02array.controller.impl.ExternalSortCommandImpl;
import by.jwd.task02array.controller.impl.InsertionSortByAddressCommandImpl;
import by.jwd.task02array.controller.impl.InsertionSortCommandImpl;
import by.jwd.task02array.controller.impl.MatrixAdditionCommandImpl;
import by.jwd.task02array.controller.impl.MatrixMultiplicationCommandImpl;
import by.jwd.task02array.controller.impl.SelectionSortCommandImpl;
import by.jwd.task02array.controller.impl.ShakerSortCommandImpl;
import by.jwd.task02array.controller.impl.ShellSortCommandImpl;
import by.jwd.task02array.controller.impl.TwoWayMergeSortCommandImpl;
import by.jwd.task02array.controller.impl.WrongRequestImpl;


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
		commands.put("9", new MatrixMultiplicationCommandImpl());
		commands.put("10", new MatrixAdditionCommandImpl());
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
