package by.jwd.task03innerclass.controller.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03innerclass.controller.Command;
import by.jwd.task03innerclass.entity.Shop;
import by.jwd.task03innerclass.service.FindService;
import by.jwd.task03innerclass.service.ServiceException;
import by.jwd.task03innerclass.service.ServiceFactory;
import by.jwd.task03innerclass.service.ShopCreatorService;
import by.jwd.task03innerclass.view.MessageManager;
import by.jwd.task03innerclass.view.Output;

public class FindAllStoreAssortmentCommandImpl implements Command{
	
	static Logger logger = LogManager.getLogger(FindAllStoreAssortmentCommandImpl.class);

	@Override
	public void execute(MessageManager current, String [] param) {

		ServiceFactory servicefactory = ServiceFactory.getInstance();

		ShopCreatorService shopService = servicefactory.getShop();

		FindService <String> service = servicefactory.getFindAllAssortment();

		Output view = new Output();

		try {
			Shop shop = shopService.create(param [0]);
			
			List <String> listOfGoodTitles  = service.find(shop);
			view.print(current.getString("res2") + listOfGoodTitles.toString());
			
		} catch (ServiceException e) {
			logger.error("file data not found or incorrect data");
			view.print(current.getString("err2"));
		}
	}
}