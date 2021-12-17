package by.jwd.task02array.controller;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.service.ArrayCreator;
import by.jwd.task02array.service.ArraySortingService;
import by.jwd.task02array.service.ServiceException;
import by.jwd.task02array.service.ServiceFactory;
import by.jwd.task02array.view.MessageManager;
import by.jwd.task02array.view.Output;

public class SelectionSortCommandImpl implements Command {

	static Logger logger = LogManager.getLogger(SelectionSortCommandImpl.class);

	@Override
	public void execute(MessageManager current) {

		ServiceFactory servicefactory = ServiceFactory.getInstance();

		ArraySortingService<Integer> service = servicefactory.getSelectionSort();

		ArrayCreator arrayCreator = servicefactory.getArrayCreator();

		Output view = new Output();

		try {
			Array<Integer> array = arrayCreator.createArrayFromFile(new File("resources/data1.txt"));
			Array<Integer> sortedArray = service.sortArray(array);
			view.print(current.getString("res3")+ sortedArray.toString());
		} catch (ServiceException e) {
			logger.error("error");
			view.print(current.getString("err2"));
		}
	}
}