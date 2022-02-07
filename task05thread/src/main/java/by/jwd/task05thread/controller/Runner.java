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

		DaoFactory factory = DaoFactory.getInstance();

		try {
			int numberOfclientRequests = factory.getReader().readDataFromFile("data.txt").size();

			Semaphore sem = new Semaphore(numberOfThreads);
			CommonResource res = new CommonResource();

			for (int i = 0; i < numberOfclientRequests; i++) {
				new Client(res, sem, "Client" + (i + 1), i).start();
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
}
