package by.jwd.task03polymorphism.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03polymorphism.entity.ItemOfCoffee;
import by.jwd.task03polymorphism.entity.VanException;
import by.jwd.task03polymorphism.entity.VanOfCoffee;
import by.jwd.task03polymorphism.service.FindByParameterService;
import by.jwd.task03polymorphism.service.LoadVanService;
import by.jwd.task03polymorphism.service.ServiceException;
import by.jwd.task03polymorphism.service.ServiceFactory;
import by.jwd.task03polymorphism.view.MessageManager;
import by.jwd.task03polymorphism.view.Output;

public class FindByParameterCommandImpl implements Command {

	static Logger logger = LogManager.getLogger(SortByNetWeightCommandImpl.class);

	@Override
	public void execute(MessageManager current, String [] []param) {

		ServiceFactory servicefactory = ServiceFactory.getInstance();

		LoadVanService loadVan = servicefactory.getLoadVan();

		FindByParameterService<String[]> service = servicefactory.getFindByParameter();

		Output view = new Output();
			
		
		try {
			VanOfCoffee van = loadVan.loadVan(Integer.parseInt(param[0][0]),(Integer.parseInt(param[0][1])));
		
			List <ItemOfCoffee> finded = service.find(param [1], van);
			view.print(current.getString("res4") + finded.toString());
			
		} catch (ServiceException |VanException e) {
			logger.error("error");
			view.print(current.getString("err2"));
		}
	}
} 