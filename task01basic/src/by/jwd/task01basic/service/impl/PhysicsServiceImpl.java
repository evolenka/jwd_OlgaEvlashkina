package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.PhysicsData;
import by.jwd.task01basic.service.PhysicsService;

public class PhysicsServiceImpl implements PhysicsService {

	@Override
	public int doCalculation(PhysicsData physicsData) {
		
		return physicsData.getBoatSpeed() * physicsData.getTimeWithStream()
				+ (physicsData.getBoatSpeed() - physicsData.getRiverSpeed()) * physicsData.getTimeAgainstStream();
	}
}