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
 * FindAllAvailiableDepartmentsServiceImpl implements interface FindService
 * <String>, find names of all departments of the shop (list of department
 * names)
 * 
 * @author evlashkina
 * @version 1
 * @param shop
 * @return List <String>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data
 */

public class FindAllAvailiableDepartmentsServiceImpl implements FindService<String> {
	
	static Logger logger = LogManager.getLogger(FindAllAvailiableDepartmentsServiceImpl.class);

	Validation validation = new Validation();

	@Override
	public List<String> find(Shop shop) throws ServiceException {

		if (!validation.isValid(shop)) {
			throw new ServiceException();
		}

		List<String> listOfDepartmentNames = new ArrayList<>();
		String departmentName;
		
		logger.debug("start find departments");
		for (int i = 0; i < shop.getDepartmentQuantity(); i++) {
			departmentName = shop.getDepartment(i).getName();
			if (!(listOfDepartmentNames.contains(departmentName))) {
				listOfDepartmentNames.add(departmentName);
			}
		}
		logger.debug("end find departments");
		return listOfDepartmentNames;
	}
}
