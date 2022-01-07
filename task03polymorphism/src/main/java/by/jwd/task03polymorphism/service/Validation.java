package by.jwd.task03polymorphism.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03polymorphism.entity.VanOfCoffee;

/**
 * Validation of VanOfCoffee object which is taken as parameter by methods of
 * FindByPatameterService interface and SortingService interface
 * 
 * @author evlashkina
 * @version 1
 * @param van
 * @return boolean
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */
public class Validation {

	static Logger logger = LogManager.getLogger(Validation.class);

	public boolean isValid(VanOfCoffee van) throws ServiceException {

		boolean res = true;
		try {
			logger.debug("start validation");

			for (int i = 0; i < van.getAssortment().size(); i++) {

				if (van.getItemOfCoffee(i).getCoffee().getPricePerKg() <= 0
						|| van.getItemOfCoffee(i).getCoffee().getNetWeight() <= 0
						|| van.getItemOfCoffee(i).getPrice() <= 0 || van.getItemOfCoffee(i).getGrossWeight() <= 0
						|| van.getItemOfCoffee(i).getPacking().getVolume() <= 0
						|| van.getItemOfCoffee(i).getPacking().getWeight() <= 0
						|| van.getItemOfCoffee(i).getPacking().getPrice() <= 0) {
					res = false;
					break;
				}
			}
			logger.debug("end validation");
			return res;
		} catch (NullPointerException e) {
			throw new ServiceException();
		}
	}
}