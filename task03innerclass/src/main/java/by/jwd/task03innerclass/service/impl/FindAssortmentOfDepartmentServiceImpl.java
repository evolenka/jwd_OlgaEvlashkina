package by.jwd.task03innerclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03innerclass.dao.DaoException;
import by.jwd.task03innerclass.dao.DaoFactory;
import by.jwd.task03innerclass.entity.Good;
import by.jwd.task03innerclass.entity.Shop;
import by.jwd.task03innerclass.service.FindByParameterService;
import by.jwd.task03innerclass.service.ServiceException;
import by.jwd.task03innerclass.service.Validation;

/**
 * FindAssortmentOfDepartmentServiceImpl implements interface
 * FindByParameterService<Good>, find assortment of the named shop department
 * 
 * @author evlashkina
 * @version 1
 * @param shop
 * @return List <Good>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data
 */

public class FindAssortmentOfDepartmentServiceImpl implements FindByParameterService<Good> {

	static Logger logger = LogManager.getLogger(FindAssortmentOfDepartmentServiceImpl.class);

	Validation validation = new Validation();
	DaoFactory daofactory = DaoFactory.getInstance();

	@Override
	public List<Good> findByParameter(String departmentName, Shop shop) throws ServiceException {

		if (!validation.isValid(shop)) {
			throw new ServiceException("Invalid data");
		}

		List<Good> assortment = new ArrayList<>();

		logger.debug("start find assortment of the named department");
		for (int i = 0; i < shop.getDepartmentQuantity(); i++) {
			if (shop.getDepartment(i).getName().equals(departmentName)) {
				for (int j = 0; j < shop.getDepartment(i).getAssortmentQuantity(); j++) {
					assortment.add(shop.getDepartment(i).getGood(j));
				}
				break;
			}
		}
		logger.debug("end find assortment of the named department");

		logger.debug("start write to file");
		try {
			daofactory.getWriteAssortment().writeDataToJSONFile(assortment, "SearchResultAssortmentOfDepartment.json");
			logger.debug("end write to file");

		} catch (DaoException e) {
			throw new ServiceException("");
		}

		return assortment;
	}
}