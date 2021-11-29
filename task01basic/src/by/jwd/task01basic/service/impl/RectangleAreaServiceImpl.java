package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.service.RectangleService;

public class RectangleAreaServiceImpl implements RectangleService {

	@Override
	public double doCalculation(Rectangle rectangle) {
		
		return rectangle.getWidth() * rectangle.getLength();
	}
}