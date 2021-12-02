package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.TriangleService;

/*19 linear task: find the area of the equilateral triangle, its height, the radius of the inscribed and circumscribed circles (part 3)*/

public class TriangleRadiusInServiceImpl implements TriangleService {

	/**
	 * Calculate the radius of the inscribed circle by the given side of the
	 * triangle
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param triangle (given side of the triangle)
	 * @return double result of calculation
	 */

	@Override
	public double doCalculation(Triangle triangle) {

		return (triangle.getSide1()) / (2 * (Math.sqrt(3)));
	}
}
