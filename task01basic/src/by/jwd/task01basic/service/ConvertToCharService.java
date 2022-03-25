
package by.jwd.task01basic.service;

public interface ConvertToCharService {

	/**
	 * Find the characters by the number designation of the character (ASCII)
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param index (number designation of the character)
	 * @return char array consisting of the characters (ASCII)
	 */

	public char[] convert(int index);
}