package by.jwd.task05thread.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.controller.Command;
import by.jwd.task05thread.entity.Array;
import by.jwd.task05thread.service.ArrayCreator;
import by.jwd.task05thread.service.ArraySortingService;
import by.jwd.task05thread.service.ServiceException;
import by.jwd.task05thread.service.ServiceFactory;
import by.jwd.task05thread.view.MessageManager;
import by.jwd.task05thread.view.Output;

public class BubbleSortCommandImpl implements Command {

	static Logger logger = LogManager.getLogger(BubbleSortCommandImpl.class);

	@Override
	public <T extends Number & Comparable<T>> void execute(MessageManager current, String[] param) {

		ServiceFactory servicefactory = ServiceFactory.getInstance();

		ArraySortingService service = servicefactory.getBubbleSort();

		ArrayCreator arrayCreator = servicefactory.getArrayCreator();

		Output view = new Output();

		try {

			String fileName = param[0];
			Array<T> array = arrayCreator.createArrayFromFile(fileName);
			Array<T> sortedArray = service.sortArray(array);
			view.print(Thread.currentThread().getName() + ": " + current.getString("res1") + sortedArray.toString());

		} catch (ServiceException e) {
			logger.error("file not founded of file data incorrect");
			view.print(current.getString("err2"));
		}
	}
}