package by.jwd.task03polymorphism.service.impl;

import java.util.List;

import by.jwd.task03polymorphism.dao.DaoException;
import by.jwd.task03polymorphism.dao.DaoFactory;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.FindByParameterService;
import by.jwd.task03polymorphism.service.ServiceException;
import by.jwd.task03polymorphism.service.Validation;

public class FindBySeveralParametersServiceImpl implements FindByParameterService<String[]> {
	
	private final DaoFactory daofactory = DaoFactory.getInstance();

	Validation validation = new Validation();

	@Override
	public List<ItemOfCoffee> find(String[] param, VanOfCoffee van) throws ServiceException {

		if (!validation.isValid(van)) {
			throw new ServiceException();
		}

		List<ItemOfCoffee> findedItem;

		VanOfCoffee vanTemp = van;
		findedItem = van.getAssortment();

		String title;

		if (!(param[0].equals(""))) {

			switch (param[0]) {
			case "1": {
				title = "зерновой";
			}
				break;
			case "2": {
				title = "молотый";
			}
				break;
			case "3": {
				title = "растворимый";
			}
				break;
			default:
				title = null;
			}

			FindByParameterService<String> service = new FindByCoffeeTypeServiceImpl();
			findedItem = service.find(title, vanTemp);
			vanTemp = new VanOfCoffee(findedItem);
		}

		if (!(param[1].equals(""))) {
			String sort;
			switch (param[1]) {
			case "1": {
				sort = "Arabica";
			}
				break;
			case "2": {
				sort = "Robusta";
			}
				break;
			case "3": {
				sort = "Liberica";
			}
				break;
			default:
				sort = null;
			}
			FindByParameterService<String> service = new FindBySortServiceImpl();
			findedItem = service.find(sort, vanTemp);
			vanTemp = new VanOfCoffee(findedItem);
		}

		if (!(param[2].equals(""))) {
			String trademark = param[2];

			FindByParameterService<String> service = new FindByTrademarkServiceImpl();
			findedItem = service.find(trademark, vanTemp);
			vanTemp = new VanOfCoffee(findedItem);
		}

		if (!(param[3].equals(""))) {
			String roastDegree;
			switch (param[3]) {
			case "1": {
				roastDegree = "темная";
			}
				break;
			case "2": {
				roastDegree = "светлая";
			}
				break;
			case "3": {
				roastDegree = "средняя";
			}
				break;
			default:
				roastDegree = null;
			}
			FindByParameterService<String> service = new FindByRoastDegreeServiceImpl();
			findedItem = service.find(roastDegree, vanTemp);
			vanTemp = new VanOfCoffee(findedItem);
		}

		if (!(param[4].equals(""))) {
			double price = Double.parseDouble(param[4]);
			FindByParameterService<Double> service = new FindByMaxPriceServiceImpl();
			findedItem = service.find(price, vanTemp);
			vanTemp = new VanOfCoffee(findedItem);
		}

		if (!(param[5].equals("")) || (!(param[6].equals("")))) {
			int minNetWeight = 0;
			int maxNetWeight = 8000;
			if (!(param[5].equals(""))) {
				minNetWeight = Integer.parseInt(param[5]);
			} else if (!(param[6].equals(""))) {
				maxNetWeight = Integer.parseInt(param[6]);
			}
			Integer[] netWeight = { minNetWeight, maxNetWeight };

			FindByParameterService<Integer[]> service = new FindByNetWeightServiceImpl();
			findedItem = service.find(netWeight, vanTemp);
			vanTemp = new VanOfCoffee(findedItem);
		}

		if (!(param[7].equals(""))) {
			String grindingDegree;
			switch (param[7]) {
			case "1": {
				grindingDegree = "тонкий";
			}
				break;
			case "2": {
				grindingDegree = "средний";
			}
				break;
			case "3": {
				grindingDegree = "крупный";
			}
				break;
			default:
				grindingDegree = null;
			}

			FindByParameterService<String> service = new FindByGrindingDegreeServiceImpl();
			findedItem = service.find(grindingDegree, vanTemp);
			vanTemp = new VanOfCoffee(findedItem);
		}

		if (!(param[8].equals(""))) {
			String shape;
			switch (param[8]) {
			case "1": {
				shape = "гранулированный";
			}
				break;
			case "2": {
				shape = "сублимированный";
			}
				break;
			case "3": {
				shape = "порошковый";
			}
				break;
			default:
				shape = null;
			}
			FindByParameterService<String> service = new FindByShapeServiceImpl();
			findedItem = service.find(shape, vanTemp);
			vanTemp = new VanOfCoffee(findedItem);
		}

		if (!(param[9].equals(""))) {
			String packing;
			switch (param[9]) {
			case "1": {
				packing = "пластиковая банка";
			}
				break;
			case "2": {
				packing = "прессованная пачка";
			}
				break;
			case "3": {
				packing = "бумажный пакет";
			}
				break;
			case "4": {
				packing = "чалды";
			}
				break;
			default:
				packing = null;
			}
			FindByParameterService<String> service = new FindByPackingTypeServiceImpl();
			findedItem = service.find(packing, vanTemp);
		}
		
		try {
			daofactory.getWriter().writeDataToJSONFile(findedItem, "SearchResult.json");

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return findedItem;
	}
}