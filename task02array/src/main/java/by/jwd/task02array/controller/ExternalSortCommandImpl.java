package by.jwd.task02array.controller;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import by.jwd.task02array.service.ServiceException;
import by.jwd.task02array.service.ServiceFactory;
import by.jwd.task02array.service.impl.ExternalSortService;
import by.jwd.task02array.view.Output;

public class ExternalSortCommandImpl implements Command {
	static Logger logger = LogManager.getLogger(ExternalSortCommandImpl.class);

	@Override
	public void execute() {

		ServiceFactory servicefactory = ServiceFactory.getInstance();

		ExternalSortService service = servicefactory.getExternalSort();
		
		
		Output view = new Output();

		try {
		service.sortArrayFromFile(new File ("source/data2.txt"));
			view.print("See array after external sort in the file");
		} catch (ServiceException e) {
			logger.error("error");
			view.print("error");
		}
	}
}