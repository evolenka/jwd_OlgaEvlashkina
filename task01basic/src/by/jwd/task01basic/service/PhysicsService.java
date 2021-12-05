package by.jwd.task01basic.service;

import by.jwd.task01basic.entity.PhysicsData;

public interface PhysicsService {

	/**
	 * Calculations over the physics data
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param PhysicsData physicsData
	 * @return int result of calculation
	 * @exception ServiceException
	 * @throws ServiceException if the argument is invalid for the calculation
	 */

	public int doCalculation(PhysicsData physicsData) throws ServiceException;
}