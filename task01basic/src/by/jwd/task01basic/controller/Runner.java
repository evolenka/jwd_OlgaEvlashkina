package by.jwd.task01basic.controller;

import by.jwd.task01basic.view.Output;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

	static Logger logger = LogManager.getLogger(Runner.class);

	public static void main(String[] args) {

		TaskManager taskManager = new TaskManager();

		Output output = new Output();

		output.showMenu();

		try {
			taskManager.doAction();

		} catch (NumberFormatException e) {
			logger.error("wrong format of args");
			output.showMessage("Incorrect input: wrong format of numbers");

		} catch (ArrayIndexOutOfBoundsException e) {
			logger.error("wrong quantity of args");
			output.showMessage("Incorrect input: wrong quantity of inputed parameters");
		}
	}
}