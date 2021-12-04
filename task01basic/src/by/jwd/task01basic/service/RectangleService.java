package by.jwd.task01basic.service;

import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.service.impl.ServiceException;

public interface RectangleService {

	public double doCalculation(Rectangle rectangle) throws ServiceException;
}