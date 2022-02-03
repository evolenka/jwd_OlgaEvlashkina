package by.jwd.task05thread.controller;

import java.util.concurrent.Semaphore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

	static Logger logger = LogManager.getLogger(Runner.class);

	public static void main(String[] args) {

		Semaphore sem = new Semaphore(3);
		CommonResource res = new CommonResource();

		for (int i = 0; i < 1; i++) {
			new Client(res, sem, "Client" + (i + 1), i).start();
		}
	}
}
