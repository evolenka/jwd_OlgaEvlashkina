package by.jwd.task03innerclass.controller;

import java.util.HashMap;
import java.util.Map;

import by.jwd.task03innerclass.controller.impl.FindAllShopAssortmentCommandImpl;
import by.jwd.task03innerclass.controller.impl.FindAllShopDepartmentCommandImpl;
import by.jwd.task03innerclass.controller.impl.FindAssortmentOfDepartmentCommandImpl;
import by.jwd.task03innerclass.controller.impl.FindDepartmentByGoodCommandImpl;
import by.jwd.task03innerclass.controller.impl.WrongRequestCommandImpl;

public class CommandProvider {
	
	private Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put("1", new FindAllShopDepartmentCommandImpl());
		commands.put("2", new FindAllShopAssortmentCommandImpl());
		commands.put("3", new FindAssortmentOfDepartmentCommandImpl());
		commands.put("4", new FindDepartmentByGoodCommandImpl());
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
