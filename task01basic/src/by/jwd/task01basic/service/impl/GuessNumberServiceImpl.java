package by.jwd.task01basic.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.service.GuessNumberService;

/*31. There are 5 random numbers in the range 1 - 15 including. Try to guess these numbers.*/

public class GuessNumberServiceImpl implements GuessNumberService {

	public List<NumberData<Integer>> doAction(NumberData<Integer> numberData) {

		NumberData<Integer> guessedNumbers = new NumberData<>();
		NumberData<Integer> unguessedNumbers = new NumberData<>();
		NumberData<Integer> mistakenNumbers = new NumberData<>();
		List<NumberData<Integer>> result = new ArrayList<>();

		/*
		 * declare an array and initialize the elements with the numbers inputed by user
		 */
		int[] usersNumbers = new int[5];
		for (int i = 0; i < usersNumbers.length; i++) {
			usersNumbers[i] = numberData.getNumberData().get(i);
		}

		/* declare an array and initialize the elements with the random numbers */
		int[] randomNumbers = new int[5];
		Random random = new Random();

		for (int i = 0; i < randomNumbers.length; i++) {
			randomNumbers[i] = random.nextInt(15) + 1;
		}

		/*
		 * find matches, add numbers guessed by user to guessedNumbers, add numbers
		 * inputed bu user which are not in random list to mistakenNumbers
		 */
		int index = -1;
		for (int i = 0; i < usersNumbers.length; i++) {
			for (int j = 0; j < randomNumbers.length; j++) {

				if (usersNumbers[i] == randomNumbers[j]) {
					guessedNumbers.addNumberData(usersNumbers[i]);
					randomNumbers[j] = 0; // reset number guessed by user
					index = i;
				}
			}
			if (index != i) {
				mistakenNumbers.addNumberData(usersNumbers[i]);
			}
		}

		/*
		 * add all ellements which are not equal to zero (not guessed bu user) to
		 * unguessedNumbers
		 */
		for (int i = 0; i < randomNumbers.length; i++) {
			if (randomNumbers[i] != 0) {
				unguessedNumbers.addNumberData(randomNumbers[i]);
			}
		}

		result.add(guessedNumbers);
		result.add(unguessedNumbers);
		result.add(mistakenNumbers);
		return result;
	}
}