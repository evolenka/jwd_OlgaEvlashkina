package by.jwd.task07xmlparser.controller;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task07xmlparser.service.BaseBuilder;
import by.jwd.task07xmlparser.service.BuildFactory;
import by.jwd.task07xmlparser.view.Input;
import by.jwd.task07xmlparser.view.Output;

public class Runner {
	static Logger logger = LogManager.getLogger(Runner.class);

	private static final String RESOURSE_DIRECTORY = "\\new workspace\\task07xmlparser\\src\\main\\resources";

	public static void main(String[] args) {

		Output output = new Output();
		Input input = new Input();

		output.print("please choose command (dom, sax or stax): \ndom - for parsing text with dom parser"
				+ "\nsax - for parsing text with sax parser" + "\nstax - for parsing text with stax parser");
		try {

			String type = input.read();
			BaseBuilder builder = BuildFactory.createParser(type);

			output.print("please input the name of xml file and the name of xsd file:");
			String[] param = input.read().split("\\s+");

			builder.buildSetVisits(RESOURSE_DIRECTORY + File.separator + param[0],
					RESOURSE_DIRECTORY + File.separator + param[1]);

			String res = builder.getVisits().toString();
			output.print(res);

		} catch (NullPointerException | IOException e1) {
			logger.error("incorrect input");
		}
	}
}