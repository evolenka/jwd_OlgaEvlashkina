package by.jwd.finaltaskweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.dao.ConnectionPool;
import by.jwd.finaltaskweb.dao.DaoException;

import by.jwd.finaltaskweb.dao.VisitDao;
import by.jwd.finaltaskweb.entity.DanceClass;
import by.jwd.finaltaskweb.entity.Membership;

import by.jwd.finaltaskweb.entity.Status;
import by.jwd.finaltaskweb.entity.Visit;

public class VisitDaoImpl implements VisitDao {

	static Logger logger = LogManager.getLogger(VisitDaoImpl.class);

	private static final String SQL_SELECT_ALL_VISIT = "SELECT visit.id, visit.membership_id, visit.danceclass_id, visit.status FROM `visit`";

	private static final String SQL_SELECT_BY_ID = "SELECT visit.membership_id, visit.danceclass_id, visit.status FROM `visit` WHERE visit.id = ?";
	private static final String SQL_SELECT_PLANNED = "SELECT visit.id, visit.membership_id, visit.danceclass_id, visit.status FROM `visit` WHERE visit.status = 'PLANNED'";
	private static final String SQL_SELECT_BY_MEMBERSHIP_AND_DANCECLASS = "SELECT visit.id, visit.status FROM `visit` WHERE visit.membership_id = ? AND visit.danceclass_id = ? ";
	private static final String SQL_SELECT_BY_DANCECLASS = "SELECT visit.id, visit.membership_id, visit.status FROM `visit` WHERE visit.danceclass_id = ? ";
	private static final String SQL_SELECT_PLANNED_BY_MEMBERSHIP = "SELECT visit.id, visit.status FROM `visit` WHERE visit.membership_id = ? AND visit.status = 'PLANNED'";
	
	private static final String SQL_INSERT_VISIT = "INSERT INTO visit(membership_id, danceclass_id) VALUES (?, ?)";

	private static final String SQL_DELETE_BY_ID = "DELETE FROM visit WHERE id = ?";

	private static final String SQL_UPDATE_VISIT = "UPDATE visit SET membership_id = ?, danceclass_id = ? WHERE id = ?";
	private static final String SQL_UPDATE_VISIT_STATUS = "UPDATE visit SET status = ? WHERE id = ?";
	private static final String SQL_UPDATE_BALANCE_QUANTITY = "UPDATE membership SET membership.balance_quantity = membership.balance_quantity-1 WHERE visit.membership_id = membership_id?";

	private Connection connection;

	ConnectionPool pool = ConnectionPool.getInstance();

	public VisitDaoImpl() {
		try {
			connection = pool.getConnection();
		} catch (DaoException e) {
			logger.error("It is impossible to connect to a database", e);
		}
	}

	@Override
	public List<Visit> readAll() throws DaoException {

		List<Visit> visits = new ArrayList<>();

		Statement statement = null;

		try {

			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_VISIT);

			while (resultSet.next()) {

				Visit visit = new Visit(resultSet.getInt(1));
				visit.setMembership(new Membership(resultSet.getInt(2)));
				visit.setDanceClass(new DanceClass(resultSet.getInt(3)));
				visit.setStatus(Status.valueOf(resultSet.getString(4)));
				visits.add(visit);
			}
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DaoException();
			}
		}
		logger.debug("visits have been read from db");
		return visits;
	}

	@Override
	public Visit readEntityById(Integer id) throws DaoException {

		Visit visit = null;

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(SQL_SELECT_BY_ID);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				visit = new Visit(id);

				visit.setMembership(new Membership(resultSet.getInt(2)));
				visit.setDanceClass(new DanceClass(resultSet.getInt(3)));
				visit.setStatus(Status.valueOf(resultSet.getString(4)));
				logger.debug("visit has been read by id");
			}

		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		return visit;
	}

	@Override
	public boolean delete(Integer id) throws DaoException {

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(SQL_DELETE_BY_ID);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DaoException();
			}
		}

		logger.debug("visit has been deleted");
		return true;
	}

	@Override
	public boolean create(Visit visit) throws DaoException {

		PreparedStatement statement = null;

		try {
			// if(!danceClass.getId()==null) {
			statement = connection.prepareStatement(SQL_INSERT_VISIT);

			statement.setInt(1, visit.getMembership().getId());
			statement.setInt(2, visit.getDanceClass().getId());

			statement.executeUpdate();
			logger.debug("visit has been created");
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DaoException();
			}
		}
		return true;
	}

	@Override
	public boolean update(Visit visit) throws DaoException {

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(SQL_UPDATE_VISIT);
			statement.setInt(1, visit.getMembership().getId());
			statement.setInt(2, visit.getDanceClass().getId());

			statement.executeUpdate();
			close(statement);

			logger.debug("visit has been updated");

		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		return true;
	}

	@Override
	public boolean updateStatus(Status status) throws DaoException {

		PreparedStatement statement = null;

		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(SQL_UPDATE_VISIT_STATUS);
			statement.setString(3, status.toString());
			statement.executeUpdate();
			close(statement);

			if (Status.ATTENDED == status) {
				statement = connection.prepareStatement(SQL_UPDATE_BALANCE_QUANTITY);
				statement.executeUpdate();
				close(statement);
				connection.commit();
			} else {
				connection.commit();
			}
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		logger.debug("status has been updated, balance quantity in membership has been decreased");
		return true;
	}

	@Override
	public List<Visit> readPlanned() throws DaoException {

		List<Visit> visits = new ArrayList<>();

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(SQL_SELECT_PLANNED);
	
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Visit visit = new Visit();
				visit.setId(resultSet.getInt(1));
				visit.setMembership(new Membership(resultSet.getInt(2)));
				visit.setDanceClass(new DanceClass(resultSet.getInt(3)));
				visit.setStatus(Status.valueOf(resultSet.getString(4)));

				logger.debug("all planned visits have been read");
			}

		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		return visits;
	}

	@Override
	public Visit readByMembershipAndDanceClass(Integer clientId, Integer danceClassId) throws DaoException {

		Visit visit = new Visit();

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(SQL_SELECT_BY_MEMBERSHIP_AND_DANCECLASS);

			statement.setInt(1, clientId);
			statement.setInt(2, danceClassId);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				
				visit.setId(resultSet.getInt(1));
				visit.setMembership(new Membership(clientId));
				visit.setDanceClass(new DanceClass(danceClassId));
				visit.setStatus(Status.valueOf(resultSet.getString(3)));
			
				logger.debug("visit has been read by client and by dance class");
			}

		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		return visit;
	}
	
	@Override
	public Visit readByDanceClass(Integer danceClassId) throws DaoException {
		Visit visit = new Visit();

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(SQL_SELECT_BY_DANCECLASS);

			statement.setInt(2, danceClassId);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				
				visit.setId(resultSet.getInt(1));
				visit.setMembership(new Membership(resultSet.getInt(2)));
				visit.setDanceClass(new DanceClass(danceClassId));
				visit.setStatus(Status.valueOf(resultSet.getString(3)));
			
				logger.debug("visit has been read by client and by dance class");
			}

		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		return visit;
	}
	
	@Override
	public List<Visit> readPlannedByMembership(Integer membershipId) throws DaoException {

		List<Visit> visits = new ArrayList<>();

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(SQL_SELECT_PLANNED_BY_MEMBERSHIP);

			statement.setInt(1, membershipId);
			
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Visit visit = new Visit();

				visit.setId(resultSet.getInt(1));
				visit.setMembership(new Membership(membershipId));
				visit.setDanceClass(new DanceClass(resultSet.getInt(2)));
				visit.setStatus(Status.valueOf(resultSet.getString(3)));
				visits.add(visit);

				logger.debug("planned visits have been read by memebership id");
			}

		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		return visits;
	}
}