package by.jwd.finaltaskweb.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.DaoFactory;
import by.jwd.finaltaskweb.dao.impl.UserDaoImpl;
import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.entity.Group;
import by.jwd.finaltaskweb.entity.Membership;
import by.jwd.finaltaskweb.entity.Schedule;
import by.jwd.finaltaskweb.entity.Status;
import by.jwd.finaltaskweb.entity.Visit;
import by.jwd.finaltaskweb.service.ServiceException;
import by.jwd.finaltaskweb.service.StudioServiceImpl;
import by.jwd.finaltaskweb.service.VisitService;

public class VisitServiceImpl extends StudioServiceImpl implements VisitService {
	
	private static Logger logger = LogManager.getLogger(VisitServiceImpl.class);

	private DaoFactory factory = DaoFactory.getInstance();

	@Override
	public List<Visit> readAll() throws ServiceException {

		List<Visit> visits = new ArrayList<>();

		try {
			visits = factory.getVisitDao(transaction).readAll();
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return visits;
	}

	@Override
	public Visit readEntityById(Integer id) throws ServiceException {
		Visit visit = null;
		try {
			visit = factory.getVisitDao(transaction).readEntityById(id);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return visit;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {

		try {
			factory.getVisitDao(transaction).delete(id);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean create(Visit visit) throws ServiceException {
		try {
			factory.getVisitDao(transaction).create(visit);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean update(Visit visit) throws ServiceException {
		try {
			factory.getVisitDao(transaction).update(visit);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public List<Visit> readPlannedByClient(Integer clientId) throws ServiceException {

		List<Visit> visits = new ArrayList<>();

		try {

			List<Membership> memberships = factory.getMembershipDao(transaction).readValidByClient(clientId);

			for (Membership membership : memberships) {

				List<Visit> visitByMembership = factory.getVisitDao(transaction).readPlannedByMembership(membership);

				for (Visit visit : visitByMembership) {
					visits.add(visit);
				}
			}
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return visits;
	}

	@Override
	public List<Visit> readPlannedByTeacher(Integer teacherId) throws ServiceException {

		List<Visit> visits = new ArrayList<>();

		try {
			List<Group> groups = factory.getGroupDao(transaction).readByTeacherId(teacherId);

			for (Group group : groups) {
				List<Schedule> schedules = factory.getScheduleDao(transaction).readByGroup(group.getId());
				for (Schedule schedule : schedules) {

					List<DanceClass> danceClasses = factory.getDanceClassDao(transaction).readBySchedule(schedule);

					for (DanceClass danceClass : danceClasses) {

						if (isPlanned(danceClass)) {

							visits.add(factory.getVisitDao(transaction).readByDanceClass(danceClass));
						}
					}
				}
			}
			transaction.close();
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

			List<Membership> memberships = factory.getMembershipDao(transaction)
					.readValidByClient(clientId);

			List<DanceClass> danceClasses = factory.getDanceClassDao(transaction).readByPeriod(startDate,
					endDate);

			for (Membership membership : memberships) {

				for (DanceClass danceClass : danceClasses) {

					Visit visit = factory.getVisitDao(transaction).readByMembershipAndDanceClass(membership,
							danceClass);

					if (visit != null) {
						visits.add(visit);
					}

				}
			}
			transaction.close();
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
			List<DanceClass> danceClasses = factory.getDanceClassDao(transaction).readByPeriod(startDate,
					endDate);

			for (DanceClass danceClass : danceClasses) {

				if (danceClass.getSchedule().getGroup().getId() == groupId) {

					visits.add(factory.getVisitDao(transaction).readByDanceClass(danceClass));
				}
			}
			transaction.close();
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
			List<Group> groups = factory.getGroupDao(transaction).readAll();

			for (Group group : groups) {
				int quantity = this.readByGroupAndPeriod(group.getId(), startDate, endDate).size();
				visits.put(group, quantity);
			}
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}

		return visits;
	}

	@Override
	public boolean isPlanned(DanceClass danceClass) throws ServiceException {
		Visit visit;
		try {
			visit =  factory.getVisitDao(transaction).readByDanceClass(danceClass);
			transaction.close();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return (Status.PLANNED == visit.getStatus() ? true : false);
	}

	@Override
	public boolean markPresence(Visit visit, Status status) throws ServiceException {
		try {
			if (status != Status.PLANNED && visit.getStatus() == Status.PLANNED || visit.getStatus() == Status.ABSENT) {
				 factory.getVisitDao(transaction).updateStatus(visit, status);
				transaction.close();
			} else {
				return false;
			}

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return true;
	}

	@Override
	public boolean cancelMarkPresence(Visit visit) throws ServiceException {
		try {
			if (visit.getStatus() != Status.PLANNED) {
				 factory.getVisitDao(transaction).cancelUpdateStatus(visit);
				transaction.close();
			} else {
				return false;
			}

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return true;
	}
}