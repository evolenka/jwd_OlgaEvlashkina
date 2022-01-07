package by.jwd.task03innerclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03innerclass.entity.Shop;
import by.jwd.task03innerclass.service.FindService;
import by.jwd.task03innerclass.service.ServiceException;
import by.jwd.task03innerclass.service.Validation;

/**
 * FindAllAvailiableAssortmentServiceImpl implements interface FindService
 * <String>, find all availiable assortment of the shop (list of the good item
 * titles)
 * 
 * @author evlashkina
 * @version 1
 * @param shop
 * @return List <String>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data
 */

public class FindAllAvailiableAssortmentServiceImpl implements FindService<String> {

	static Logger logger = LogManager.getLogger(FindAllAvailiableAssortmentServiceImpl.class);

	Validation validation = new Validation();

	@Override
	public List<String> find(Shop shop) throws ServiceException {

		if (!validation.isValid(shop)) {
			throw new ServiceException();
		}

		List<String> listOfGoodTitles = new ArrayList<>();
		String title;

		logger.debug("start find assortment");
		for (int i = 0; i < shop.getDepartmentQuantity(); i++) {
			for (int j = 0; j < shop.getDepartment(i).getAssortmentQuantity(); j++) {
				title = shop.getDepartment(i).getGood(j).getTitle();
				if (!(listOfGoodTitles.contains(title))) {
					listOfGoodTitles.add(title);
				}
			}
		}
		logger.debug("end find assortment");
		return listOfGoodTitles;
	}
}