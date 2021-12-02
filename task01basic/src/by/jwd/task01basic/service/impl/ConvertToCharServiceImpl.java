package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.service.ConvertToCharService;

/*33 linear task: input any character and find the previous and the next characters (second part of task)*/

public class ConvertToCharServiceImpl implements ConvertToCharService {
	
	/**
	 * Find the previous and the next characters by the number designation of the character
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param index (number designation of the character)
	 * @return char array consisting of the next and the previous characters
	 */
	
	@Override
	public char[] convert(int index) {

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