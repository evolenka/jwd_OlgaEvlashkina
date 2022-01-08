package by.jwd.task03innerclass.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03innerclass.entity.Shop;

/**
 * Validation of Store object
 * 
 * @author evlashkina
 * @version 1
 * @param shop
 * @return boolean
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */
public class Validation {

	static Logger logger = LogManager.getLogger(Validation.class);

	public boolean isValid(Shop shop) throws ServiceException {

		logger.debug("start validation");
		boolean res = true;
		try {
			for (int i = 0; i < shop.getDepartmentQuantity(); i++) {
				for (int j = 0; j < shop.getDepartment(i).getAssortmentQuantity(); j++) {

					if (shop.getDepartment(i).getGood(j).getPrice() <= 0
							|| shop.getDepartment(i).getGood(j).getQuantity() <= 0) {
						res = false;
						break;
					}
				}
			}
			logger.debug("end validation");
			return res;
		} catch (NullPointerException e) {
			throw new ServiceException();
		}
	}
}
