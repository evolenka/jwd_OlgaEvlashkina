package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.TriangleService;

public class TriangleRadiusOutServiceImpl implements TriangleService {
	
	@Override
	public double doCalculation(Triangle triangle) {
		
		return triangle.getSide1() / (Math.sqrt(3));
	}
}
