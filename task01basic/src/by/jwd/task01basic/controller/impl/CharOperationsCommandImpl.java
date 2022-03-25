package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.view.Output;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.service.ConvertToCharService;
import by.jwd.task01basic.service.ConvertToIntService;

public class CharOperationsCommandImpl implements Command {

	private ConvertToIntService convertToInt;
	private ConvertToCharService convertToChar;
	char character;

	public CharOperationsCommandImpl(ConvertToIntService convertToInt, ConvertToCharService convertToChar,
			char character) {
		this.convertToInt = convertToInt;
		this.convertToChar = convertToChar;
		this.character = character;
	}

	@Override
	public void execute() {

		Output output = new Output();

		int index = convertToInt.convert(character);
		char[] result = convertToChar.convert(index);

		output.showResponce("The index of your character: " + Integer.toString(index) + "\nThe next character: "
				+ Character.toString(result[0]) + "\nThe previous character: " + Character.toString(result[1]));
	}
}