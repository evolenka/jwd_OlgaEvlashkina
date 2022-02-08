package by.jwd.task05thread.controller;

import java.util.concurrent.Semaphore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task05thread.dao.DaoException;
import by.jwd.task05thread.dao.DaoFactory;

public class Runner {

	static Logger logger = LogManager.getLogger(Runner.class);

	public static void main(String[] args) {

		int numberOfThreads = Runtime.getRuntime().availableProcessors();

		try {
			
			Semaphore sem = new Semaphore(numberOfThreads);
			CommonResource res = new CommonResource();
			
			//quantity of client`s requests
			int numberOfClientRequests = DaoFactory.getInstance().getReader().readDataFromFile("data.txt").size();

			for (int i = 0; i < numberOfClientRequests; i++) {
				new Client(res, sem, "Client" + (i + 1), i).start();
			}
		} catch (DaoException e) {
			logger.error("reading of client`s commands from file has not been successfull");
		}
	}
}
