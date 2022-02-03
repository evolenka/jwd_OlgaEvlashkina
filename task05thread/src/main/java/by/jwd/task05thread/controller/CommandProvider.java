package by.jwd.task05thread.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.controller.impl.BubbleSortCommandImpl;
import by.jwd.task05thread.controller.impl.InsertionSortByAddressCommandImpl;
import by.jwd.task05thread.controller.impl.InsertionSortCommandImpl;
import by.jwd.task05thread.controller.impl.MatrixAdditionCommandImpl;
import by.jwd.task05thread.controller.impl.MatrixMultiplicationCommandImpl;
import by.jwd.task05thread.controller.impl.MatrixTranspositionCommandImpl;
import by.jwd.task05thread.controller.impl.SelectionSortCommandImpl;
import by.jwd.task05thread.controller.impl.ShakerSortCommandImpl;
import by.jwd.task05thread.controller.impl.ShellSortCommandImpl;
import by.jwd.task05thread.controller.impl.TwoWayMergeSortCommandImpl;
import by.jwd.task05thread.controller.impl.WrongRequestImpl;


public class CommandProvider {
	
	static Logger logger = LogManager.getLogger(CommandProvider.class);
	
	private Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put("1", new BubbleSortCommandImpl());
		commands.put("2", new InsertionSortCommandImpl());
		commands.put("3", new SelectionSortCommandImpl());
		commands.put("4", new ShakerSortCommandImpl());
		commands.put("5", new ShellSortCommandImpl());
		commands.put("6", new TwoWayMergeSortCommandImpl());
		commands.put("7", new InsertionSortByAddressCommandImpl());
		commands.put("8", new MatrixMultiplicationCommandImpl());
		commands.put("9", new MatrixAdditionCommandImpl());
		commands.put("10", new MatrixTranspositionCommandImpl());
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
		logger.debug("command has been identified: {}", Thread.currentThread().getName());
		return command;
	}
}
