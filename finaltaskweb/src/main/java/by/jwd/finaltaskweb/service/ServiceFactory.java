package by.jwd.finaltaskweb.service;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.TransactionFactoryImpl;
import by.jwd.finaltaskweb.service.impl.BuilderClient;
import by.jwd.finaltaskweb.service.impl.DanceClassServiceImpl;
import by.jwd.finaltaskweb.service.impl.GroupServiceImpl;
import by.jwd.finaltaskweb.service.impl.MembershipServiceImpl;
import by.jwd.finaltaskweb.service.impl.ScheduleServiceImpl;
import by.jwd.finaltaskweb.service.impl.UserServiceImpl;
import by.jwd.finaltaskweb.service.impl.VisitServiceImpl;

public class ServiceFactory {

	private static final ServiceFactory instance = new ServiceFactory();
	private static final TransactionFactoryImpl factory = TransactionFactoryImpl.getInstance();
	
	private StudioServiceImpl userservice = new UserServiceImpl();
	private StudioServiceImpl membershipService = new MembershipServiceImpl();
	private StudioServiceImpl danceClassService = new DanceClassServiceImpl();
	private StudioServiceImpl groupService = new GroupServiceImpl();
	private StudioServiceImpl visitService = new VisitServiceImpl();
	private StudioServiceImpl scheduleService = new ScheduleServiceImpl();
	private BuilderClient clientBuilder = new BuilderClient();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public UserService getUserService() throws ServiceException {
		
		try {
			userservice.setTransaction(factory.createTransaction());
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return (UserService) userservice;
	}

	public MembershipService getMembershipService() throws ServiceException {
		
		try {
			membershipService.setTransaction(factory.createTransaction());
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return (MembershipService) membershipService;
	}

	public DanceClassService getDanceClassService() throws ServiceException {
		
		try {
			danceClassService.setTransaction(factory.createTransaction());
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return (DanceClassService) danceClassService;
	}

	public VisitService getVisitservice() throws ServiceException {
		
		try {
			visitService.setTransaction(factory.createTransaction());
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return (VisitService) visitService;
	}

	public GroupService getGroupService() throws ServiceException {
		
		try {
			groupService.setTransaction(factory.createTransaction());
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return (GroupService) groupService;
	}

	public ScheduleServiceImpl getScheduleService() throws ServiceException {
		
		try {
			scheduleService.setTransaction(factory.createTransaction());
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return (ScheduleServiceImpl) scheduleService;
	}

	public BuilderClient getClientBuilder() {
		return clientBuilder;
	}
}