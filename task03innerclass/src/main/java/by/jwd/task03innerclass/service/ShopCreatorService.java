package by.jwd.task03innerclass.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03innerclass.dao.DaoException;
import by.jwd.task03innerclass.dao.DaoFactory;
import by.jwd.task03innerclass.entity.Shop;

/**
 * Creation of Shop object
 * 
 * @author evlashkina
 * @version 1
 * @param fileName
 * @return Shop
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */

public class ShopCreatorService {

	static Logger logger = LogManager.getLogger(ShopCreatorService.class);

	private final DaoFactory daofactory = DaoFactory.getInstance();

	Validation validation = new Validation();

	public Shop create(String fileName) throws ServiceException {

		Shop shop;

		logger.debug("get shop object from json file");
		try {
			shop = daofactory.getReader().readDataFromJSON(fileName);
			if (!validation.isValid(shop)) {
				throw new ServiceException();
			}
			return shop;
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}
}
