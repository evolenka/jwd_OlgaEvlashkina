package by.jwd.task02array.controller;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.service.ArrayCreatorService;
import by.jwd.task02array.service.ArrayService;
import by.jwd.task02array.service.ServiceException;
import by.jwd.task02array.service.ServiceFactory;
import by.jwd.task02array.view.Output;

public class TwoWayMergeSortCommandImpl implements Command {

	static Logger logger = LogManager.getLogger(TwoWayMergeSortCommandImpl.class);

	@Override
	public void execute() {

		ServiceFactory servicefactory = ServiceFactory.getInstance();

		ArrayService<Integer> service = servicefactory.getMergeSort();

		ArrayCreatorService arrayCreator = servicefactory.getArrayCreator();

		Output view = new Output();

		try {
			Array<Integer> array = arrayCreator.createArrayFromFile(new File("source/data2.txt"));
			Array<Integer> sortedArray = service.sortArray(array);
			view.print("Array after two way merge sort:\n " + sortedArray.toString());
		} catch (ServiceException e) {
			logger.error("error");
			view.print("error");
		}
	}
} 