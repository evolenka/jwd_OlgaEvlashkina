 package by.jwd.task01basic.service;

import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.impl.ServiceException;

public interface TriangleService {

	public double doCalculation(Triangle triangle) throws ServiceException;
}