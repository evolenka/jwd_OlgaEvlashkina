package by.jwd.task06infohandling.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.view.Input;
import by.jwd.task06infohandling.view.Output;

public class Runner {

	static Logger logger = LogManager.getLogger(Runner.class);

	public static void main(String[] args) {

		Output output = new Output();
		Input input = new Input();

		CommandProvider provider = new CommandProvider();
		Command command;

		output.print("please choose command: \n1 - parse text from file and collect"
				+ "\n2 - sort paragraphs by quantity of sentences" + "\n3 - sort words in the sentences by length"
				+ "\n4 - sort lexemes by quantity of the repetitions of the inputed character");
		try {

			String commandName = input.read();
			String[] param = null;

			if ("4".equals(commandName)) {
				output.print("input filename and character");
			} else {
				output.print("input filename");
			}
			param = input.read().split("\\s+");
			command = provider.getCommand(commandName);
			command.execute(param);
			
		} catch (IOException e) {
			logger.error("incorrect input");
			output.print ("incorrect input");
		} catch (ArrayIndexOutOfBoundsException e) {
			logger.error("wrong quantity of args");
			output.print ("wrong quantity of args");
		}
	}
}