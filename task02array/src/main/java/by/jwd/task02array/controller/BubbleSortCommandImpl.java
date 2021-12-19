package by.jwd.task02array.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.service.ArrayCreator;
import by.jwd.task02array.service.ArraySortingService;
import by.jwd.task02array.service.ServiceException;
import by.jwd.task02array.service.ServiceFactory;
import by.jwd.task02array.view.MessageManager;
import by.jwd.task02array.view.Output;

public class BubbleSortCommandImpl implements Command {

	static Logger logger = LogManager.getLogger(BubbleSortCommandImpl.class);

	@Override
	public void execute(MessageManager current, String[] param) {

		ServiceFactory servicefactory = ServiceFactory.getInstance();

		ArraySortingService<Integer> service = servicefactory.getBubbleSort();

		ArrayCreator arrayCreator = servicefactory.getArrayCreator();

		Output view = new Output();

	
		try {
			
			String fileName = param[0];
			Array<Integer> array = arrayCreator.createArrayFromFile(fileName);
			Array<Integer> sortedArray = service.sortArray(array);
			view.print(current.getString("res1") + sortedArray.toString());

		} catch (ServiceException e) {
			logger.error("error");
			view.print(current.getString("err2"));
		}
	}
}