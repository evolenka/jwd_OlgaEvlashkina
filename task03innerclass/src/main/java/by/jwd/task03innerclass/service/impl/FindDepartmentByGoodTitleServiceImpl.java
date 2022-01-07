package by.jwd.task03innerclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03innerclass.dao.DaoException;
import by.jwd.task03innerclass.dao.DaoFactory;
import by.jwd.task03innerclass.entity.Shop;
import by.jwd.task03innerclass.service.FindByParameterService;
import by.jwd.task03innerclass.service.ServiceException;
import by.jwd.task03innerclass.service.Validation;

/**
 * FindDepartmentByGoodTitleServiceImpl implements interface
 * FindByParameterService<String>, find the name(s) of the shop department(s),
 * where the named good can be bought
 * 
 * @author evlashkina
 * @version 1
 * @param shop
 * @return List <String>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data
 */

public class FindDepartmentByGoodTitleServiceImpl implements FindByParameterService<String> {

	static Logger logger = LogManager.getLogger(FindDepartmentByGoodTitleServiceImpl.class);

	Validation validation = new Validation();
	DaoFactory daofactory = DaoFactory.getInstance();

	@Override
	public List<String> findByParameter(String goodTitle, Shop shop) throws ServiceException {

		if (!validation.isValid(shop)) {
			throw new ServiceException();
		}

		List<String> listOfDepartmentNames = new ArrayList<>();

		logger.debug("start find department by good title");
		for (int i = 0; i < shop.getDepartmentQuantity(); i++) {
			for (int j = 0; j < shop.getDepartment(i).getAssortmentQuantity(); j++) {
				if (shop.getDepartment(i).getGood(j).getTitle().equals(goodTitle)
						&& (!listOfDepartmentNames.contains(shop.getDepartment(i).getName()))) {
					listOfDepartmentNames.add(shop.getDepartment(i).getName());
				}
			}
		}
		logger.debug("end find department by good title");

		logger.debug("start write to file");
		try {
			daofactory.getWriteDepartmentList().writeDataToJSONFile(listOfDepartmentNames,
					"SearchResultDepartmentByGood.json");
			logger.debug("end write to file");

		} catch (DaoException e) {
			throw new ServiceException("");
		}
		return listOfDepartmentNames;
	}
}
