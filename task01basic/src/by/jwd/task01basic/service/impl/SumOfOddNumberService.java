package by.jwd.task01basic.service.impl;

/*5. Calculate the sum of all odd numbers from 1 to 99 (including) using while.*/

public class SumOfOddNumberService {

	public int sumOfOddNumbers() {
		int i = 0;
		int sum = 0;
		
		while (i < 100) {
			if (i % 2 != 0) {
				sum = sum +i;
			}
			i++;
		}
		return sum;
	}
}