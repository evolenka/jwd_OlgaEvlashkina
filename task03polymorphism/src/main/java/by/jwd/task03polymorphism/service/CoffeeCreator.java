package by.jwd.task03polymorphism.service;

import by.jwd.task03polymorphism.entity.BeanCoffee;
import by.jwd.task03polymorphism.entity.Coffee;
import by.jwd.task03polymorphism.entity.GroundCoffee;
import by.jwd.task03polymorphism.entity.InstantCoffee;

public class CoffeeCreator {

	public Coffee create(String title, String sort, String trademark, String roastDegree,
			double pricePerKg, int netWeight, String grindingDegree, String shape) throws IllegalArgumentException {

		Coffee coffee = null;
		
		if (pricePerKg < 0 || netWeight < 0) {
			throw new IllegalArgumentException ();
		}

		if (title.equals("зерновой")) {
			coffee = new BeanCoffee(sort, trademark, roastDegree, pricePerKg, netWeight);
		}

		if (title.equals("молотый")) {
			coffee = new GroundCoffee(sort, trademark, roastDegree, pricePerKg, netWeight, grindingDegree);
		}

		else if (title.equals("растворимый")) {
			coffee = new InstantCoffee(sort, trademark, roastDegree, pricePerKg, netWeight, shape);
		}
		return coffee;
	}
}
