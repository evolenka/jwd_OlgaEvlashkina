package by.jwd.task02array.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task02array.service.ServiceException;
import by.jwd.task02array.service.ServiceFactory;
import by.jwd.task02array.service.impl.ExternalSortService;
import by.jwd.task02array.view.MessageManager;
import by.jwd.task02array.view.Output;

public class ExternalSortCommandImpl implements Command {
	static Logger logger = LogManager.getLogger(ExternalSortCommandImpl.class);

	@Override
	public void execute(MessageManager current, String[] param) {

		ServiceFactory servicefactory = ServiceFactory.getInstance();

		ExternalSortService service = servicefactory.getExternalSort();

		Output view = new Output();

		

		try {
			
			String fileName = param[0];
			service.sortArrayFromFile(fileName);
			view.print(current.getString("res8"));
			
		} catch (ServiceException e) {
			
			logger.error("error");
			view.print(current.getString("err2"));
		}
	}
}