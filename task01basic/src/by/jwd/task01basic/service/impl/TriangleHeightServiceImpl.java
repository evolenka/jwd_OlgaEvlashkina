package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.TriangleService;

/*19 linear task: find the area of the equilateral triangle, its height, the radius of the inscribed and circumscribed circles (part 2)*/

public class TriangleHeightServiceImpl implements TriangleService {

	/**
	 * Calculate the heigth of the equilateral triangle by the given side
	 * 
	 * @author evlashkina
	 * @version 1
	 * @param triangle (given side of the triangle)
	 * @return double result of calculation
	 */

	@Override
	public double doCalculation(Triangle triangle) {

		return (Math.sqrt(3)) / 2 * triangle.getSide1();
	}
}