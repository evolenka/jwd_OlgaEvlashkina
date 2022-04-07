package by.jwd.finaltaskweb.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.jwd.finaltaskweb.dao.DaoException;
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

	@Override
	public List<Visit> readAll() throws ServiceException {

		List<Visit> visits = new ArrayList<>();

		try {
			visits = transaction.createDaoFactory().getVisitDao().readAll();
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
			visit = transaction.createDaoFactory().getVisitDao().readEntityById(id);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return visit;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {

		try {
			transaction.createDaoFactory().getVisitDao().delete(id);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean create(Visit visit) throws ServiceException {
		try {
			transaction.createDaoFactory().getVisitDao().create(visit);
			transaction.close();

		} catch (DaoException e) {
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean update(Visit visit) throws ServiceException {
		try {
			transaction.createDaoFactory().getVisitDao().update(visit);
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

			List<Membership> memberships = transaction.createDaoFactory().getMembershipDao()
					.readValidByClient(clientId);

			for (Membership membership : memberships) {

				List<Visit> visitByMembership = transaction.createDaoFactory().getVisitDao()
						.readPlannedByMembership(membership);

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
			List<Group> groups = transaction.createDaoFactory().getGroupDao().readByTeacherId(teacherId);

			for (Group group : groups) {
				List<Schedule> schedules = transaction.createDaoFactory().getScheduleDao().readByGroup(group.getId());
				for (Schedule schedule : schedules) {

					List<DanceClass> danceClasses = transaction.createDaoFactory().getDanceClassDao()
							.readBySchedule(schedule);

					for (DanceClass danceClass : danceClasses) {

						if (isPlanned(danceClass)) {

							visits.add(transaction.createDaoFactory().getVisitDao().readByDanceClass(danceClass));
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

			List<Membership> memberships = transaction.createDaoFactory().getMembershipDao()
					.readValidByClient(clientId);

			List<DanceClass> danceClasses = transaction.createDaoFactory().getDanceClassDao().readByPeriod(startDate,
					endDate);

			for (Membership membership : memberships) {

				for (DanceClass danceClass : danceClasses) {

					Visit visit = transaction.createDaoFactory().getVisitDao().readByMembershipAndDanceClass(membership,
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
			List<DanceClass> danceClasses = transaction.createDaoFactory().getDanceClassDao().readByPeriod(startDate,
					endDate);

			for (DanceClass danceClass : danceClasses) {

				if (danceClass.getSchedule().getGroup().getId() == groupId) {

					visits.add(transaction.createDaoFactory().getVisitDao().readByDanceClass(danceClass));
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
			List<Group> groups = transaction.createDaoFactory().getGroupDao().readAll();

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
			visit = transaction.createDaoFactory().getVisitDao().readByDanceClass(danceClass);
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
			transaction.createDaoFactory().getVisitDao().updateStatus(visit, status);
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
			transaction.createDaoFactory().getVisitDao().cancelUpdateStatus(visit);
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