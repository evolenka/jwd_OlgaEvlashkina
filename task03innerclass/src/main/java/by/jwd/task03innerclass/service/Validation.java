package by.jwd.task03innerclass.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03innerclass.entity.Shop;

/**
 * Validation of Store object
 * 
 * @author evlashkina
 * @version 1
 * @param store
 * @return boolean
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */
public class Validation {

	static Logger logger = LogManager.getLogger(Validation.class);

	public boolean isValid(Shop store) throws ServiceException {

		logger.debug("start validation");
		boolean res = true;
		try {
			for (int i = 0; i < store.getDepartmentQuantity(); i++) {
				for (int j = 0; j < store.getDepartment(i).getAssortmentQuantity(); j++) {

					if (store.getDepartment(i).getGood(j).getPrice() <= 0
							|| store.getDepartment(i).getGood(j).getQuantity() <= 0) {
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
