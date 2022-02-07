package by.jwd.task05thread.controller;

import java.util.List;
import java.util.concurrent.Semaphore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.dao.DaoException;
import by.jwd.task05thread.dao.DaoFactory;
import by.jwd.task05thread.service.DataParser;
import by.jwd.task05thread.view.MessageManager;

public class Client extends Thread {

	static Logger logger = LogManager.getLogger(Client.class);

	private static final int QUANTITY1 = 8;//quantity of client params for operations with two matrixes
	private static final int QUANTITY2 = 6;//quantity of client params for operations with one matrix (trasposition)

	private int threadId;
	Semaphore sem;
	CommonResource res;

	Client() {
	}

	Client(CommonResource res, Semaphore sem, String name, int threadId) {
		super(name);
		this.res = res;
		this.sem = sem;
		this.threadId = threadId;
	}

	@Override
	public void run() {

		try {
			logger.debug("waiting for permission: {}", Thread.currentThread().getName());

			sem.acquire();
			res.count++;

			logger.debug("thread has started: {}", Thread.currentThread().getName());

			List<String> fileData = null;

			DaoFactory factory = DaoFactory.getInstance();

			fileData = factory.getReader().readDataFromFile("data.txt");

			DataParser parser = DataParser.getInstance();

			String[] lineParam = parser.parse(fileData, threadId);

			MessageManager current;

			String language = lineParam[0];

			switch (language) {
			case "1":
				current = MessageManager.EN;
				break;
			case "2":
				current = MessageManager.RU;
				break;
			default:
				current = MessageManager.EN;
			}

			CommandProvider provider = new CommandProvider();
			Command command;

			String commandName = lineParam[1];

			String[] param;

			if (commandName.equals("8") || commandName.equals("9")) {
				param = new String[QUANTITY1];
				for (int i = 2, j = 0; j < param.length && i < lineParam.length; i++, j++) {
					param[j] = lineParam[i];
				}
			} else if (commandName.equals("10")) {
				param = new String[QUANTITY2];
				for (int i = 2, j = 0; j < param.length && i < lineParam.length; i++, j++) {
					param[j] = lineParam[i];
				}
			} else {
				param = new String[1];
				param[0] = lineParam[2];
			}

			command = provider.getCommand(commandName);
			command.execute(current, param);
		} catch (DaoException e) {
			logger.error("Incorrect input");

		} catch (InterruptedException e) {
			logger.warn("Interrupted!", e);
			Thread.currentThread().interrupt();
		}
		logger.debug("thread has released the permission: {} ", Thread.currentThread().getName());
		sem.release();
		res.count--;
		logger.debug("thread has finished: {} ", Thread.currentThread().getName());
	}
}

class CommonResource {
	int count = 0;
}
