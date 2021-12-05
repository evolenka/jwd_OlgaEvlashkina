package by.jwd.task01basic.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import by.jwd.task01basic.entity.PhysicsData;
import by.jwd.task01basic.service.PhysicsService;
import by.jwd.task01basic.service.ServiceException;

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
	 * @exception ServiceException
	 * @throws ServiceException if the argument is invalid for the calculation
	 */
	static Logger logger = LogManager.getLogger(PhysicsServiceImpl.class);

	@Override
	public int doCalculation(PhysicsData physicsData) throws ServiceException {
		try {
			// validation
			if (physicsData.getBoatSpeed() < 0 || physicsData.getTimeWithStream() < 0 || physicsData.getRiverSpeed() < 0
					|| physicsData.getTimeAgainstStream() < 0) {
				throw new IllegalArgumentException();
			}
			return physicsData.getBoatSpeed() * physicsData.getTimeWithStream()
					+ (physicsData.getBoatSpeed() - physicsData.getRiverSpeed()) * physicsData.getTimeAgainstStream();
		} catch (IllegalArgumentException e) {
			logger.error("negative number (or = 0)");
			throw new ServiceException();
		}
	}
}