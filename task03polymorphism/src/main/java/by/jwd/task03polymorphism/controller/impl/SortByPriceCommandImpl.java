package by.jwd.task03polymorphism.controller.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03polymorphism.controller.Command;
import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.LoadVanService;
import by.jwd.task03polymorphism.service.ServiceException;
import by.jwd.task03polymorphism.service.ServiceFactory;
import by.jwd.task03polymorphism.service.SortingService;
import by.jwd.task03polymorphism.view.MessageManager;
import by.jwd.task03polymorphism.view.Output;

public class SortByPriceCommandImpl implements Command {

	static Logger logger = LogManager.getLogger(SortByPriceCommandImpl.class);

	@Override
	public void execute(MessageManager current, String [][]param) {

		ServiceFactory servicefactory = ServiceFactory.getInstance();

		LoadVanService loadVan = servicefactory.getLoadVan();

		SortingService service = servicefactory.getSortByPrice();

		Output view = new Output();

		try {
		
			VanOfCoffee van = loadVan.loadVan(Integer.parseInt(param[0][0]),(Integer.parseInt(param[0][1])),param [0][2]);
			
			List <ItemOfCoffee> sorted = service.sort(van);
			view.print(current.getString("res1") + sorted.toString());
			
		} catch (ServiceException e) {
			logger.error("file data not found or incorrect data");
			view.print(current.getString("err2"));
		}
	}
}