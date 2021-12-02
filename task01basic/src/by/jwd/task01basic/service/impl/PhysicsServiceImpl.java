package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.PhysicsData;
import by.jwd.task01basic.service.PhysicsService;

/*31 linear task: calculate the distance traveled by the boat, if its speed in still water is V (km / h),
 * the speed of the river is V1 (km / h), the time of movement on the river is T1 (h), and time against the stream of the river - T2 (h)*/

public class PhysicsServiceImpl implements PhysicsService {

	/**
	 * Calculate the distance traveled by boat, given that the boat speed in still
	 * water is V (km / h), the speed of the river is V1 (km / h), the time of
	 * movement on the river is T1 (h), and time of movement against the stream of
	 * the river - T2 (h)
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param physicsData (given data)
	 * @return int result of distance calculation
	 */

	@Override
	public int doCalculation(PhysicsData physicsData) {

		return physicsData.getBoatSpeed() * physicsData.getTimeWithStream()
				+ (physicsData.getBoatSpeed() - physicsData.getRiverSpeed()) * physicsData.getTimeAgainstStream();
	}
}