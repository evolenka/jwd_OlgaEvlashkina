package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.TriangleService;

public class TriangleRadiusInServiceImpl implements TriangleService {
	
	@Override
	public double doCalculation(Triangle triangle) {
		
		return (triangle.getSide1()) / (2 * (Math.sqrt(3)));
	}
}
