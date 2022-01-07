package by.jwd.task03innerclass.service;

import by.jwd.task03innerclass.entity.Good;
import by.jwd.task03innerclass.service.impl.FindAllAvailiableAssortmentServiceImpl;
import by.jwd.task03innerclass.service.impl.FindAllAvailiableDepartmentsServiceImpl;
import by.jwd.task03innerclass.service.impl.FindAssortmentOfDepartmentServiceImpl;
import by.jwd.task03innerclass.service.impl.FindDepartmentByGoodTitleServiceImpl;

/**
 * ServiceFactory for the access to the Service classes objects
 * 
 * @author evlashkina
 * @version 1
 */

public class ServiceFactory {

	private static final ServiceFactory instance = new ServiceFactory();

	private ShopCreatorService shop = new ShopCreatorService();
	private FindService<String> findAllDepartment = new FindAllAvailiableDepartmentsServiceImpl();
	private FindService<String> findAllAssortment = new FindAllAvailiableAssortmentServiceImpl();
	private FindByParameterService<Good> findGoodByDepartment = new FindAssortmentOfDepartmentServiceImpl();
	private FindByParameterService<String> findDepartmentByGood = new FindDepartmentByGoodTitleServiceImpl();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public ShopCreatorService getShop() {
		return shop;
	}

	public void setShop(ShopCreatorService shop) {
		this.shop = shop;
	}

	public FindService<String> getFindAllDepartment() {
		return findAllDepartment;
	}

	public void setFindAllDepartment(FindService<String> findAllDepartment) {
		this.findAllDepartment = findAllDepartment;
	}
	
	public FindService<String> getFindAllAssortment() {
		return findAllAssortment;
	}

	public void setFindAllAssortment(FindService<String> findAllAssortment) {
		this.findAllAssortment = findAllAssortment;
	}

	public FindByParameterService<Good> getFindGoodByDepartment() {
		return findGoodByDepartment;
	}

	public void setFindGoodByDepartment(FindByParameterService<Good> findGoodByDepartment) {
		this.findGoodByDepartment = findGoodByDepartment;
	}

	public FindByParameterService<String> getfindDepartmentByGood() {
		return findDepartmentByGood;
	}

	public void setFindDepartmentByGood(FindByParameterService<String> findDepartmentByGood) {
		this.findDepartmentByGood = findDepartmentByGood;
	}
}
