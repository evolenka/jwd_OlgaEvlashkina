package by.jwd.finaltaskweb.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.DaoFactory;
import by.jwd.finaltaskweb.entity.Membership;
import by.jwd.finaltaskweb.entity.MembershipType;
import by.jwd.finaltaskweb.service.MembershipService;
import by.jwd.finaltaskweb.service.ServiceException;

public class MembershipServiceImpl implements MembershipService {

	private DaoFactory factory = DaoFactory.getInstance();

	@Override
	public boolean create(Membership membership) throws ServiceException {
		try {
			factory.getMembershipDao().create(membership);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean update(Membership membership) throws ServiceException {
		try {
			factory.getMembershipDao().update(membership);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {
		try {
			factory.getMembershipDao().delete(id);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public List<Membership> readAll() throws ServiceException {
		
		List<Membership> memberships = new ArrayList<>();
		try {
			memberships = factory.getMembershipDao().readAll();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return memberships;
	}

	@Override
	public Membership readEntityById(Integer id) throws ServiceException {
		Membership membership = new Membership();
		try {
			membership = factory.getMembershipDao().readEntityById(id);

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return membership;
	}

	@Override
	public List<Membership> readByClientAndPeriod(Integer clientId, LocalDate startDate, LocalDate endDate)
			throws ServiceException {
		List<Membership> memberships = new ArrayList<>();;
		try {
			memberships = factory.getMembershipDao().readByClientAndPeriod(clientId, startDate, endDate);

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return memberships;
	}

	@Override
	public List<Membership> readValidByClient(Integer clientId) throws ServiceException {
		
		List<Membership> memberships = new ArrayList<>();
		try {
			memberships = factory.getMembershipDao().readValidByClient(clientId);

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return memberships;
	}

	@Override
	public List<Membership> readByPeriod(LocalDate startDate, LocalDate endDate) throws ServiceException {
		List<Membership> memberships = null;
		try {
			memberships = factory.getMembershipDao().readByPeriod(startDate, endDate);

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return memberships;
	}

	@Override
	public double countSumForPeriod(LocalDate startDate, LocalDate endDate) throws ServiceException {
		double sum = 0;
		List<Membership> memberships = readByPeriod(startDate, endDate);
		for (Membership membership : memberships) {
			sum += membership.getType().getPrice();
		}
		return sum;
	}

	@Override
	public int countQuantityForPeriod(LocalDate startDate, LocalDate endDate) throws ServiceException {
		int quantity = 0;
		List<Membership> memberships = readByPeriod(startDate, endDate);
		for (Membership membership : memberships) {
			quantity += membership.getType().getPrice();
		}
		return quantity;
	}

	@Override
	public List<MembershipType> readAllTypes() throws ServiceException {
		List<MembershipType> memberships = null;
		try {
			memberships = factory.getMembershipDao().readAllTypes();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return memberships;
	}

	@Override
	public boolean deleteType(Integer id) throws ServiceException {
		try {
			factory.getMembershipDao().deleteType(id);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean createType(MembershipType type) throws ServiceException {
		try {
			factory.getMembershipDao().createType(type);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean updateType(MembershipType type) throws ServiceException {
		try {
			factory.getMembershipDao().updateType(type);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}
}