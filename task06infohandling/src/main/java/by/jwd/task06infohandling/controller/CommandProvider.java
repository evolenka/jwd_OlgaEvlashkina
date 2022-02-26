  package by.jwd.task06infohandling.controller;

import java.util.HashMap;
import java.util.Map;

import by.jwd.task06infohandling.controller.impl.ParseAndCollectCommandImpl;
import by.jwd.task06infohandling.controller.impl.SortLexemeByQuantityOfGivenSymbolCommandImpl;
import by.jwd.task06infohandling.controller.impl.SortParagraphsBySentenceQuantityCommandImpl;
import by.jwd.task06infohandling.controller.impl.SortWordsByLengthCommandImpl;
import by.jwd.task06infohandling.controller.impl.WrongRequestCommandImpl;

public class CommandProvider {

	private Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {

		commands.put("1", new ParseAndCollectCommandImpl());
		commands.put("2", new SortParagraphsBySentenceQuantityCommandImpl());
		commands.put("3", new SortWordsByLengthCommandImpl());
		commands.put("4", new SortLexemeByQuantityOfGivenSymbolCommandImpl());
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