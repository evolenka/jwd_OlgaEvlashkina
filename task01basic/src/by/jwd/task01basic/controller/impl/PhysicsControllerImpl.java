package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.PhysicsData;
import by.jwd.task01basic.service.PhysicsService;
import by.jwd.task01basic.service.impl.PhysicsServiceImpl;
import by.jwd.task01basic.view.IoData;

public class PhysicsControllerImpl implements Command {
	IoData iodata = new IoData();
	PhysicsService physicsService = new PhysicsServiceImpl();
	PhysicsData physicsData = new PhysicsData();

	@Override
	public String execute(String[] params) throws IllegalArgumentException {
		try {
			for (String i : params) {
				if (Integer.parseInt(i) < 0) {
					throw new IllegalArgumentException();
				}
			}
			physicsData.setBoatSpeed(Integer.parseInt(params[0]));
			physicsData.setRiverSpeed(Integer.parseInt(params[1]));
			physicsData.setTimeWithStream(Integer.parseInt(params[2]));
			physicsData.setTimeAgainstStream(Integer.parseInt(params[3]));
			
			int result = physicsService.doCalculation(physicsData);
			return iodata.printResponce("The distance =  ", Integer.toString(result));
			
		} catch (NumberFormatException e) {
			return iodata.print("Incorrect input: wrong format of numbers");
			
		} catch (IllegalArgumentException e) {
			return iodata.print("Incorrect input: numbers should be positive");
			
		} catch (ArrayIndexOutOfBoundsException e) {
			return iodata.print("Incorrect input: four numbers are requested");
		}
	}
}