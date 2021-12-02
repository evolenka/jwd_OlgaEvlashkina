package by.jwd.task01basic.controller;

import by.jwd.task01basic.view.Input;
import by.jwd.task01basic.view.Output;

/* Java Basics tasks:
 * Linear tasks (5,7,19,31,33)
 * Condidional tasks (5,7,19,31,33)
 * Loops tasks (5,7,19,31,33)
 * Extra task (to swap numbers in 3 ways)*/

public class Runner {

	public static void main(String[] args) {

		Output output = new Output();
		Input input = new Input();

		TaskProvider provider = new TaskProvider();
		String commandName;

		/* show menu to user */
		output.showMenu();

		/* ask user to choose point in menu */
		output.print("Please choose the respective point of menu (1, 2, 3 or 4)\n>>");
		commandName = input.read();
		provider.doAction(commandName);
	}
}