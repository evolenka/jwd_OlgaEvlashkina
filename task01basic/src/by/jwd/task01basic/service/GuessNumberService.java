package by.jwd.task01basic.service;

import java.util.List;
import by.jwd.task01basic.entity.NumberData;

public interface GuessNumberService {

	/**
	 * Compare random numbers to the numbers of the user
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param numberData (list of int numbers)
	 * @return list of lists of guessed, unguessed and mistaken numbers
	 */

	public List<NumberData<Integer>> guess(NumberData<Integer> numberData);
}