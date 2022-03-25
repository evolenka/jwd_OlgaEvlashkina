package by.jwd.task03polymorphism.service;

import by.jwd.task03polymorphism.service.impl.FindBySeveralParametersServiceImpl;
import by.jwd.task03polymorphism.service.impl.SortingByNetWeightServiceImpl;
import by.jwd.task03polymorphism.service.impl.SortingByPriceServiceImpl;
import by.jwd.task03polymorphism.service.impl.SortingByPriceToNetWeightRatioServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private LoadVanService loadVan = new LoadVanService();
	private SortingService sortByPrice = new SortingByPriceServiceImpl();
	private SortingService sortByNetWeight = new SortingByNetWeightServiceImpl();
	private SortingService sortByRatio = new SortingByPriceToNetWeightRatioServiceImpl();
	private FindByParameterService<String[]> findByParameter = new FindBySeveralParametersServiceImpl();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public LoadVanService getLoadVan() {
		return loadVan;
	}

	public void setLoadVan(LoadVanService loadVan) {
		this.loadVan = loadVan;
	}

	public SortingService getSortByPrice() {
		return sortByPrice;
	}

	public void setSortByPrice(SortingService sortByPrice) {
		this.sortByPrice = sortByPrice;
	}

	public SortingService getSortByNetWeight() {
		return sortByNetWeight;
	}

	public void setSortByNetWeight(SortingService sortByNetWeight) {
		this.sortByNetWeight = sortByNetWeight;
	}

	public SortingService getSortByRatio() {
		return sortByRatio;
	}

	public void setSortByRatio(SortingService sortByRatio) {
		this.sortByRatio = sortByRatio;
	}

	public FindByParameterService<String[]> getFindByParameter() {
		return findByParameter;
	}

	public void setFindByParameter(FindByParameterService<String[]> findByParameter) {
		this.findByParameter = findByParameter;
	}

}