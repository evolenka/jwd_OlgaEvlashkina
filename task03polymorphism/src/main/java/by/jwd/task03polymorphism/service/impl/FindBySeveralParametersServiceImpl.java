package by.jwd.task03polymorphism.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03polymorphism.dao.DaoException;
import by.jwd.task03polymorphism.dao.DaoFactory;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.FindByParameterService;
import by.jwd.task03polymorphism.service.MaxNetWeightService;
import by.jwd.task03polymorphism.service.ServiceException;
import by.jwd.task03polymorphism.service.Validation;

/**
 * Find coffee item by parameters among assortment loaded in the van
 * 
 * @author evlashkina
 * @version 1
 * @param param, van
 * @return List<ItemOfCoffee>
 * @exception ServiceException
 * @throws ServiceException in case of invalid data or file not found
 */
public class FindBySeveralParametersServiceImpl implements FindByParameterService<String[]> {

	static Logger logger = LogManager.getLogger(FindBySeveralParametersServiceImpl.class);

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
		logger.debug("end parse");

		logger.debug("start find");
		try {
			if (parsedParam.get(0) != null) {

				FindByParameterService<String> service = new FindByCoffeeTypeServiceImpl();
				findedItem = service.find(parsedParam.get(0), vanTemp);
				logger.debug("find item by coffee type");
				vanTemp = new VanOfCoffee(findedItem);
			}

			if (parsedParam.get(1) != null) {
				FindByParameterService<String> service = new FindBySortServiceImpl();
				findedItem = service.find(parsedParam.get(1), vanTemp);
				logger.debug("find item by sort");
				vanTemp = new VanOfCoffee(findedItem);
			}

			if (parsedParam.get(2) != null) {
				FindByParameterService<String> service = new FindByTrademarkServiceImpl();
				findedItem = service.find(parsedParam.get(2), vanTemp);
				logger.debug("find item by trademark");
				vanTemp = new VanOfCoffee(findedItem);
			}

			if (parsedParam.get(3) != null) {

				FindByParameterService<String> service = new FindByRoastDegreeServiceImpl();
				findedItem = service.find(parsedParam.get(3), vanTemp);
				logger.debug("find item by roast degree");
				vanTemp = new VanOfCoffee(findedItem);
			}

			if (parsedParam.get(4) != null) {

				FindByParameterService<Double> service = new FindByMaxPriceServiceImpl();
				findedItem = service.find(Double.parseDouble(parsedParam.get(4)), vanTemp);
				logger.debug("find item by max price");
				vanTemp = new VanOfCoffee(findedItem);
			}

			if ((parsedParam.get(5) != null) || parsedParam.get(6) != null) {

				MaxNetWeightService max = new MaxNetWeightService();
				int minNetWeight = 0;
				int maxNetWeight = max.findMaxNetWeight(vanTemp);
				logger.debug("find max net weight");

				if (parsedParam.get(5) != null) {
					minNetWeight = Integer.parseInt(param[5]);
					logger.debug("initiation of min net weight");
				}
				if (parsedParam.get(6) != null) {
					maxNetWeight = Integer.parseInt(param[6]);
					logger.debug("initiation of max net weight");
				}
				Integer[] netWeight = { minNetWeight, maxNetWeight };

				FindByParameterService<Integer[]> service = new FindByNetWeightServiceImpl();
				findedItem = service.find(netWeight, vanTemp);
				logger.debug("find item by net weight");
				vanTemp = new VanOfCoffee(findedItem);
			}

			if (parsedParam.get(7) != null) {
				FindByParameterService<String> service = new FindByGrindingDegreeServiceImpl();
				findedItem = service.find(parsedParam.get(7), vanTemp);
				logger.debug("find item by grinding degree");
				vanTemp = new VanOfCoffee(findedItem);
			}

			if (parsedParam.get(8) != null) {
				FindByParameterService<String> service = new FindByShapeServiceImpl();
				findedItem = service.find(parsedParam.get(8), vanTemp);
				logger.debug("find item by shape");
				vanTemp = new VanOfCoffee(findedItem);
			}

			if (parsedParam.get(9) != null) {
				FindByParameterService<String> service = new FindByPackingTypeServiceImpl();
				findedItem = service.find(parsedParam.get(9), vanTemp);
				logger.debug("find item by packing");
			}

			logger.debug("start write to json file");
			
			daofactory.getWriter().writeDataToJSONFile(findedItem, "SearchResult.json");
			
			logger.debug("end write to json file");
		} catch (DaoException | NumberFormatException e) {
			throw new ServiceException();
		}
		return findedItem;
	}

	public List<String> parseParam(String[] param) {

		List<String> list = new ArrayList<>();

		String title;
		if (!(param[0].equals(""))) {
			
			logger.debug("start initiation of title");
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
		logger.debug("end initiation of title");

		String sort;
		if (!(param[1].equals(""))) {
			
			logger.debug("start initiation of sort");

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
		logger.debug("end initiation of sort");

		String trademark;
		if (!(param[2].equals(""))) {
			logger.debug("start initiation of trademark");
			trademark = param[2];
		} else {
			trademark = null;
		}

		list.add(trademark);
		logger.debug("end initiation of trademark");

		String roastDegree;
		if (!(param[3].equals(""))) {
			
			logger.debug("start initiation of roastDegree");
			
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
		logger.debug("end initiation of roastDegree");

		String price;
		if (!(param[4].equals(""))) {
			logger.debug("start initiation of price");
			price = param[4];
		} else
			price = null;
		list.add(price);
		logger.debug("end initiation of price");

		String minNetWeight;

		if (!(param[5].equals(""))) {
			logger.debug("start initiation of net weight");
			minNetWeight = param[5];
		} else
			minNetWeight = null;
		list.add(minNetWeight);
		logger.debug("end initiation of net weight");

		String maxNetWeight;
		if (!(param[6].equals(""))) {
			logger.debug("start initiation of max weight");
			maxNetWeight = param[6];
		} else {
			maxNetWeight = null;
		}
		list.add(maxNetWeight);
		logger.debug("end initiation of max weight");

		String grindingDegree;
		if (!(param[7].equals(""))) {
			
			logger.debug("start initiation of grinding degree");

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
		logger.debug("end initiation of grinding degree");

		String shape;
		if (!(param[8].equals(""))) {
			
			logger.debug("start initiation of shape");

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
		logger.debug("end initiation of shape");

		String packing;
		if (!(param[9].equals(""))) {
			
			logger.debug("start initiation of packing");

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
		logger.debug("end initiation of packing");

		return list;
	}
}
