package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.PhysicsData;
import by.jwd.task01basic.service.PhysicsService;
import by.jwd.task01basic.service.impl.PhysicsServiceImpl;
import by.jwd.task01basic.view.IoData;

public class PhysicsControllerImpl implements Command {
	IoData iodata = new IoData();
	PhysicsService physicsService = new PhysicsServiceImpl();

	@Override
	public String execute(String[] params) {
		try {
			PhysicsData physicsData = new PhysicsData();
			physicsData.setBoatSpeed(Integer.parseInt(params[0]));
			physicsData.setRiverSpeed(Integer.parseInt(params[1]));
			physicsData.setTimeWithStream(Integer.parseInt(params[2]));
			physicsData.setTimeAgainstStream(Integer.parseInt(params[3]));

			int result = physicsService.doCalculation(physicsData);
			return iodata.printResponce("The distance =  ", Integer.toString(result));
		} catch (NumberFormatException e) {
			return iodata.print("Incorrect format of numbers");
		}

		catch (ArrayIndexOutOfBoundsException e) {
			return iodata.print("Four numbers are requested");
		}
	}
}