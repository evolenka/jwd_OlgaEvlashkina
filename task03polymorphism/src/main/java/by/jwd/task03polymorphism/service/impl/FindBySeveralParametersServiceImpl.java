package by.jwd.task03polymorphism.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.jwd.task03polymorphism.dao.DaoException;
import by.jwd.task03polymorphism.dao.DaoFactory;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.FindByParameterService;
import by.jwd.task03polymorphism.service.MaxNetWeightService;
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

		List<String> parsedParam = parseParam(param);
		try {
			if (parsedParam.get(0) != null) {

				FindByParameterService<String> service = new FindByCoffeeTypeServiceImpl();
				findedItem = service.find(parsedParam.get(0), vanTemp);
				vanTemp = new VanOfCoffee(findedItem);
			}

			if (parsedParam.get(1) != null) {
				FindByParameterService<String> service = new FindBySortServiceImpl();
				findedItem = service.find(parsedParam.get(1), vanTemp);
				vanTemp = new VanOfCoffee(findedItem);
			}

			if (parsedParam.get(2) != null) {
				FindByParameterService<String> service = new FindByTrademarkServiceImpl();
				findedItem = service.find(parsedParam.get(2), vanTemp);
				vanTemp = new VanOfCoffee(findedItem);
			}

			if (parsedParam.get(3) != null) {

				FindByParameterService<String> service = new FindByRoastDegreeServiceImpl();
				findedItem = service.find(parsedParam.get(3), vanTemp);
				vanTemp = new VanOfCoffee(findedItem);
			}

			if (parsedParam.get(4) != null) {

				FindByParameterService<Double> service = new FindByMaxPriceServiceImpl();
				findedItem = service.find(Double.parseDouble(parsedParam.get(4)), vanTemp);
				vanTemp = new VanOfCoffee(findedItem);
			}

			if ((parsedParam.get(5) != null) || parsedParam.get(6) != null) {

				MaxNetWeightService max = new MaxNetWeightService();
				int minNetWeight = 0;
				int maxNetWeight = max.findMaxNetWeight(vanTemp);

				if (parsedParam.get(5) != null) {
					minNetWeight = Integer.parseInt(param[5]);
				}
				if (parsedParam.get(6) != null) {
					maxNetWeight = Integer.parseInt(param[6]);
				}
				Integer[] netWeight = { minNetWeight, maxNetWeight };

				FindByParameterService<Integer[]> service = new FindByNetWeightServiceImpl();
				findedItem = service.find(netWeight, vanTemp);
				vanTemp = new VanOfCoffee(findedItem);
			}

			if (parsedParam.get(7) != null) {
				FindByParameterService<String> service = new FindByGrindingDegreeServiceImpl();
				findedItem = service.find(parsedParam.get(7), vanTemp);
				vanTemp = new VanOfCoffee(findedItem);
			}

			if (parsedParam.get(8) != null) {
				FindByParameterService<String> service = new FindByShapeServiceImpl();
				findedItem = service.find(parsedParam.get(8), vanTemp);
				vanTemp = new VanOfCoffee(findedItem);
			}

			if (parsedParam.get(9) != null) {
				FindByParameterService<String> service = new FindByPackingTypeServiceImpl();
				findedItem = service.find(parsedParam.get(9), vanTemp);
			}
			daofactory.getWriter().writeDataToJSONFile(findedItem, "SearchResult.json");
		} catch (DaoException | NumberFormatException e) {
			throw new ServiceException();
		}
		return findedItem;
	}

	public List<String> parseParam(String[] param) {

		List<String> list = new ArrayList<>();

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
		} else {
			title = null;
		}

		list.add(title);

		String sort;
		if (!(param[1].equals(""))) {

			switch (param[1]) {
			case "1": {
				sort = "арабика";
			}
				break;
			case "2": {
				sort = "робуста";
			}
				break;
			case "3": {
				sort = "либерика";
			}
				break;
			default:
				sort = null;
			}
		} else {
			sort = null;
		}

		list.add(sort);

		String trademark;
		if (!(param[2].equals(""))) {
			trademark = param[2];
		} else {
			trademark = null;
		}

		list.add(trademark);

		String roastDegree;
		if (!(param[3].equals(""))) {
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
		}

		else {
			roastDegree = null;
		}
		list.add(roastDegree);

		String price;
		if (!(param[4].equals(""))) {
			price = param[4];
		} else
			price = null;
		list.add(price);

		String minNetWeight;

		if (!(param[5].equals(""))) {
			minNetWeight = param[5];
		} else
			minNetWeight = null;
		list.add(minNetWeight);

		String maxNetWeight;
		if (!(param[6].equals(""))) {
			maxNetWeight = param[6];
		} else {
			maxNetWeight = null;
		}
		list.add(maxNetWeight);

		String grindingDegree;
		if (!(param[7].equals(""))) {

			switch (param[7]) {
			case "1": {
				grindingDegree = "мелкий";
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
		} else {
			grindingDegree = null;
		}

		list.add(grindingDegree);

		String shape;
		if (!(param[8].equals(""))) {

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
		} else {
			shape = null;
		}

		list.add(shape);

		String packing;
		if (!(param[9].equals(""))) {

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
			case "5": {
				packing = "стеклянная банка";
			}
				break;
			default:
				packing = null;
			}
		} else {
			packing = null;
		}

		list.add(packing);

		return list;
	}
}
