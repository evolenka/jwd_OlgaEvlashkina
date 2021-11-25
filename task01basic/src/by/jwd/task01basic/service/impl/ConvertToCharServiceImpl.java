package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.service.ConvertToCharService;

public class ConvertToCharServiceImpl implements ConvertToCharService {

	public char[] doAction(int index) {

		char[] result = new char[2];

		char nextChar;
		char previousChar;

		if (index == 32) {
			nextChar = (char) (index + 1);
			previousChar = '0';
		}

		else if (index == 126) {
			nextChar = '0';
			previousChar = (char) (index - 1);
		} else {
			nextChar = (char) (index + 1);
			previousChar = (char) (index - 1);
		}

		result[0] = nextChar;
		result[1] = previousChar;
		return result;
	}
}