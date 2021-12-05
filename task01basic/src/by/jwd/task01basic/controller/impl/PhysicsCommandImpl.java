package by.jwd.task01basic.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.PhysicsData;
import by.jwd.task01basic.service.PhysicsService;
import by.jwd.task01basic.service.ServiceException;
import by.jwd.task01basic.view.Output;

public class PhysicsCommandImpl implements Command {

	static Logger logger = LogManager.getLogger(PhysicsCommandImpl.class);

	private PhysicsService physicsService;
	private PhysicsData physicsData;

	public PhysicsCommandImpl(PhysicsService physicsService, PhysicsData physicsData) {
		this.physicsService = physicsService;
		this.physicsData = physicsData;
	}

	@Override
	public void execute() {

		Output output = new Output();

		try {
			int result = physicsService.doCalculation(physicsData);
			output.showResponce("The distance =  " + Integer.toString(result));

		} catch (ServiceException e) {
			logger.error("negative number (or = 0)");
			output.showMessage("Incorrect input:  number(s) should be positive");
		}
	}
}