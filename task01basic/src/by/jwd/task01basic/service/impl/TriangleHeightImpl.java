package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.TriangleService;

public class TriangleHeightImpl implements TriangleService{
	@Override
	public double doCalculation(Triangle triangle) {
		return (Math.sqrt(3)) / 2 * triangle.getSide1();
	}
}