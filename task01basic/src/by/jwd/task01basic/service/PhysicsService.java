package by.jwd.task01basic.service;

import by.jwd.task01basic.entity.PhysicsData;
import by.jwd.task01basic.service.impl.ServiceException;

public interface PhysicsService {

	public int doCalculation(PhysicsData physicsData) throws ServiceException;
}