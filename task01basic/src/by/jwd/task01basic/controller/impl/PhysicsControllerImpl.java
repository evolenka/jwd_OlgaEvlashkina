package by.jwd.task01basic.controller.impl;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.entity.PhysicsData;
import by.jwd.task01basic.service.PhysicsService;
import by.jwd.task01basic.service.impl.PhysicsServiceImpl;
import by.jwd.task01basic.view.Output;

public class PhysicsControllerImpl implements Command {

	Output output = new Output();
	PhysicsService physicsService = new PhysicsServiceImpl();
	PhysicsData physicsData = new PhysicsData();

	@Override
	public String execute(String[] params) {

		int result;

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

			result = physicsService.doCalculation(physicsData);
			return output.printResponce("The distance =  ", Integer.toString(result));

		} catch (NumberFormatException e) {
			return output.print("Incorrect input: wrong format of numbers");

		} catch (IllegalArgumentException e) {
			return output.print("Incorrect input: numbers should be positive");

		} catch (ArrayIndexOutOfBoundsException e) {
			return output.print("Incorrect input: four numbers are requested");
		}
	}
}