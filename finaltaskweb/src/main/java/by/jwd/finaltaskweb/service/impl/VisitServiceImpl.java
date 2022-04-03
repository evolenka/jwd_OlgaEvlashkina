package by.jwd.finaltaskweb.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.DaoFactory;
import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.entity.Membership;
import by.jwd.finaltaskweb.entity.Visit;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.ServiceFactory;
import by.jwd.finaltaskweb.service.VisitService;

public class VisitServiceImpl implements VisitService {

	private DaoFactory factory = DaoFactory.getInstance();
	private ServiceFactory serviceFactory = ServiceFactory.getInstance();

	@Override
	public List<Visit> readAll() throws ServiceException {

		List<Visit> visits = new ArrayList<>();

		try {
			visits = factory.getVisitDao().readAll();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return visits;
	}

	@Override
	public Visit readEntityById(Integer id) throws ServiceException {
		Visit visit = null;
		try {
			visit = factory.getVisitDao().readEntityById(id);

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return visit;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {

		try {
			factory.getVisitDao().delete(id);

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean create(Visit visit) throws ServiceException {
		try {
			factory.getVisitDao().create(visit);

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean update(Visit visit) throws ServiceException {
		try {
			factory.getVisitDao().update(visit);

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public List<Visit> readPlannedByClient(Integer clientId) throws ServiceException {

		List<Visit> visits = new ArrayList<>();

		try {

			List<Membership> memberships = factory.getMembershipDao().readValidByClient(clientId);

			for (Membership membership : memberships) {

				List<Visit> visitByMembership = new ArrayList<>();

				visitByMembership = factory.getVisitDao().readPlannedByMembership(membership.getId());

				for (Visit visit : visitByMembership) {
					visits.add(visit);
				}
			}
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return visits;
	}

	@Override
	public List<Visit> readPlannedByTeacher(Integer teacherId) throws ServiceException {

		List<Visit> visits = new ArrayList<>();
		try {
			List<Visit> plannedVisits = factory.getVisitDao().readPlanned();

			List<Group> groups = factory.getGroupDao().readByTeacherId(teacherId);

			for (Group group : groups) {
				List<DanceClass> danceClasses = serviceFactory.getDanceClassService().readByGroup(group.getId());

				for (DanceClass danceClass : danceClasses) {

					for (Visit visit : plannedVisits) {

						if (visit.getDanceClass().equals(danceClass))
							visits.add(visit);
					}

				}
			}
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return visits;

	}

	@Override
	public List<Visit> readByClientAndPeriod(Integer clientId, LocalDate startDate, LocalDate endDate)
			throws ServiceException {

		List<Visit> visits = new ArrayList<>();

		try {

			List<Membership> memberships = factory.getMembershipDao().readValidByClient(clientId);

			List<DanceClass> danceClasses = factory.getDanceClassDao().readByPeriod(startDate, endDate);

			for (Membership membership : memberships) {

				for (DanceClass danceClass : danceClasses) {

					Visit visit = factory.getVisitDao().readByMembershipAndDanceClass(membership.getId(),
							danceClass.getId());

					if (visit != null) {
						visits.add(visit);
					}

				}
			}
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return visits;
	}

	@Override
	public List<Visit> readByGroupAndPeriod(Integer groupId, LocalDate startDate, LocalDate endDate)
			throws ServiceException {

		List<Visit> visits = new ArrayList<>();
		try {
			List<DanceClass> danceClasses = factory.getDanceClassDao().readByPeriod(startDate, endDate);

			for (DanceClass danceClass : danceClasses) {

				if (danceClass.getSchedule().getGroup().getId() == groupId) {

					visits.add(factory.getVisitDao().readByDanceClass(danceClass.getId()));
				}

			}
		} catch (DaoException e) {
			throw new ServiceException();
		}

		return visits;
	}

	@Override
	public Map<Group, Integer> countVisitsForPeriodByGroups(LocalDate startDate, LocalDate endDate)
			throws ServiceException {

		Map<Group, Integer> visits = new HashMap<>();
		try {
			List<Group> groups = factory.getGroupDao().readAll();

			for (Group group : groups) {
				int quantity = this.readByGroupAndPeriod(group.getId(), startDate, endDate).size();
				visits.put(group, quantity);
			}
		} catch (DaoException e) {
			throw new ServiceException();
		}

		return visits;
	}
}