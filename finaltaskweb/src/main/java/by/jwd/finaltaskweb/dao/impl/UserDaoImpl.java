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
import by.jwd.finaltaskweb.dao.UserDao;
import by.jwd.finaltaskweb.entity.Client;
import by.jwd.finaltaskweb.entity.Role;
import by.jwd.finaltaskweb.entity.Teacher;
import by.jwd.finaltaskweb.entity.User;

public class UserDaoImpl implements UserDao {

	static Logger logger = LogManager.getLogger(UserDaoImpl.class);

	private static final String SQL_SELECT_ALL_USER = "SELECT user.id, user.login, user.password, user.role FROM `user`";
	private static final String SQL_SELECT_ALL_CLIENT = "SELECT user.id, user.login, user.password, client.surname, client.name, client.patronymic, client.phone, client.email FROM `user` join `client` ON user.id = client.id";
	private static final String SQL_SELECT_ALL_TEACHER = "SELECT user.id, user.login, user.password, teacher.surname, teacher.name, teacher.dancestyle, teacher.portfolio from `user` join `teacher` ON user.id = teacher.id";
	private static final String SQL_SELECT_ALL_DANCESTYLE = "SELECT DISTINCT dancestyle FROM `teacher`";

	private static final String SQL_SELECT_BY_ID = "SELECT user.login, user.password, user.role, client.surname, client.name, client.patronymic, client.phone, client.email, teacher.surname, teacher.name, teacher.dancestyle, teacher.portfolio FROM `user` LEFT JOIN `client` ON user.id = client.id LEFT JOIN `teacher` on user.id = teacher.id WHERE user.id = ?";
	private static final String SQL_SELECT_BY_LOGIN = "SELECT user.id, user.login, user.password, user.role, client.surname, client.name, client.patronymic, client.phone, client.email, teacher.surname, teacher.name, teacher.dancestyle, teacher.portfolio FROM `user` LEFT JOIN `client` ON user.id = client.id LEFT JOIN `teacher` on user.id = teacher.id WHERE user.login = ?";
	private static final String SQL_SELECT_BY_SURNAME = "SELECT user.id, user.login, user.password, user.role, client.surname, client.name, client.patronymic, client.phone, client.email, teacher.surname, teacher.name, teacher.dancestyle, teacher.portfolio FROM `user` LEFT JOIN `client` ON user.id = client.id LEFT JOIN `teacher` on user.id = teacher.id WHERE teacher.surname = ? OR client.surname = ?";
	private static final String SQL_SELECT_BY_DANCESTYLE = "SELECT user.id, user.login, user.password, user.role, teacher.name, teacher.surname, teacher.dancestyle, teacher.portfolio FROM `user` join `teacher`ON user.id = teacher.id WHERE teacher.dancestyle = ?";

	private static final String SQL_INSERT_USER = "INSERT INTO user(login, password, role) VALUES (?, ?, ?)";
	private static final String SQL_INSERT_CLIENT = "INSERT INTO client (id, surname, name, patronymic, phone, email)  VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SQL_INSERT_TEACHER = "INSERT INTO teacher (id, surname, name, dancestyle, teacher.portfolio)  VALUES (?, ?, ?, ?)";

	private static final String SQL_DELETE_BY_ID = "DELETE FROM user WHERE id = ?";

	private static final String SQL_UPDATE_USER = "UPDATE user SET login = ?, password = ?, role = ? WHERE id = ?";
	private static final String SQL_UPDATE_CLIENT = "UPDATE client SET surname = ?,name = ?, patronymic = ?, phone = ?, email = ? WHERE id = ?";
	private static final String SQL_UPDATE_TEACHER = "UPDATE teacher SET surname = ?, name = ?, dancestyle = ? teacher.portfolio = ? WHERE id = ?";

	private Connection connection;

	ConnectionPool pool = ConnectionPool.getInstance();
	
	public UserDaoImpl() {
		try {
			connection = pool.getConnection();
		} catch (DaoException e) {
			logger.error("It is impossible to connect to a database", e);
		}
	}

	@Override
	public List<User> readAll() throws DaoException {

		List<User> users = new ArrayList<>();
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USER);

			while (resultSet.next()) {

				User user = new User(resultSet.getInt(1));

				user.setLogin(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setRole(Role.valueOf(resultSet.getString(4)));
				users.add(user);
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
		logger.debug("users have been read from db");
		return users;
	}

	@Override
	public List<Client> readAllClient() throws DaoException {

		List<Client> clients = new ArrayList<>();
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_CLIENT);

			while (resultSet.next()) {

				Client client = new Client(resultSet.getInt(1));

				client.setLogin(resultSet.getString(2));
				client.setPassword(resultSet.getString(3));
				client.setSurname(resultSet.getString(4));
				client.setName(resultSet.getString(5));
				client.setPatronymic(resultSet.getString(6));
				client.setPhone(resultSet.getString(7));
				client.setEmail(resultSet.getString(8));

				clients.add(client);
			}
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		logger.debug("clients have been read from db");
		return clients;
	}

	@Override
	public List<Teacher> readAllTeacher() throws DaoException {

		List<Teacher> teachers = new ArrayList<>();
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_TEACHER);

			while (resultSet.next()) {

				Teacher teacher = new Teacher(resultSet.getInt(1));

				teacher.setLogin(resultSet.getString(2));
				teacher.setPassword(resultSet.getString(3));
				teacher.setSurname(resultSet.getString(4));
				teacher.setName(resultSet.getString(5));
				teacher.setDanceStyle(resultSet.getString(6));
				teacher.setPortfolio(resultSet.getString(7));

				teachers.add(teacher);
			}
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		logger.debug("teachers have been read from db");
		return teachers;
	}

	@Override
	public User readEntityById(Integer id) throws DaoException {

		User user = null;

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(SQL_SELECT_BY_ID);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Role role = Role.valueOf(resultSet.getString(3));

				if (role == Role.CLIENT) {
					user = new Client(id);
					user.setLogin(resultSet.getString(1));
					user.setPassword(resultSet.getString(2));
					user.setSurname(resultSet.getString(4));
					user.setName(resultSet.getString(5));
					((Client) user).setPatronymic(resultSet.getString(6));
					((Client) user).setPhone(resultSet.getString(7));
					((Client) user).setEmail(resultSet.getString(8));
					logger.debug("client has been read by id");

				} else if (role == Role.TEACHER) {
					user = new Teacher(id);
					user.setLogin(resultSet.getString(1));
					user.setPassword(resultSet.getString(2));
					user.setSurname(resultSet.getString(9));
					user.setName(resultSet.getString(10));
					((Teacher) user).setDanceStyle(resultSet.getString(11));
					((Teacher) user).setPortfolio(resultSet.getString(12));

					logger.debug("teacher has been read by id");

				} else {
					user = new User(id);
					user.setLogin(resultSet.getString(1));
					user.setPassword(resultSet.getString(2));
					user.setRole(role);

					logger.debug("user has been read by id");
				}
			}

		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		return user;
	}

	@Override
	public User readByLogin(String login) throws DaoException {

		User user = null;

		PreparedStatement statement = null;

		try {

			statement = connection.prepareStatement(SQL_SELECT_BY_LOGIN);
			statement.setString(1, login);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Role role = Role.valueOf(resultSet.getString(4));

				if (role == Role.CLIENT) {
					user = new Client(resultSet.getInt(1));
					user.setLogin(resultSet.getString(2));
					user.setPassword(resultSet.getString(3));
					user.setSurname(resultSet.getString(5));
					user.setName(resultSet.getString(6));
					((Client) user).setPatronymic(resultSet.getString(7));
					((Client) user).setPhone(resultSet.getString(8));
					((Client) user).setEmail(resultSet.getString(9));
					logger.debug("client has been read by login");

				} else if (role == Role.TEACHER) {
					user = new Teacher(resultSet.getInt(1));
					user.setLogin(resultSet.getString(2));
					user.setPassword(resultSet.getString(3));
					user.setSurname(resultSet.getString(10));
					user.setName(resultSet.getString(11));
					((Teacher) user).setDanceStyle(resultSet.getString(12));
					((Teacher) user).setPortfolio(resultSet.getString(13));


					logger.debug("teacher has been read by login");

				} else {
					user = new User(resultSet.getInt(1));
					user.setLogin(resultSet.getString(2));
					user.setPassword(resultSet.getString(3));
					user.setRole(role);

					logger.debug("user has been read by login");
				}
			}
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		logger.debug("user has been read by login");
		return user;
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
		}
		logger.debug("user has been deleted");
		return true;
	}

	@Override
	public boolean create(User user) throws DaoException {

		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, user.getLogin());
			statement.setString(2, user.getPassword());
			Role role = user.getRole();
			statement.setString(3, role.toString());
			statement.executeUpdate();
			logger.debug("user has been created");

			ResultSet resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				int key = resultSet.getInt(1);
				close(statement);

				if (role == Role.CLIENT) {

					statement = connection.prepareStatement(SQL_INSERT_CLIENT);
					Client client = (Client) user;
					statement.setInt(1, key);
					statement.setString(2, client.getSurname());
					statement.setString(3, client.getName());
					statement.setString(4, client.getPatronymic());
					statement.setString(5, client.getPhone());
					statement.setString(6, client.getEmail());
					statement.executeUpdate();
					logger.debug("client has been created");

				} else if (role == Role.TEACHER) {

					statement = connection.prepareStatement(SQL_INSERT_TEACHER);
					Teacher teacher = (Teacher) user;
					statement.setInt(1, key);
					statement.setString(2, teacher.getSurname());
					statement.setString(3, teacher.getName());
					statement.setString(4, teacher.getDanceStyle());
					statement.setString(5, teacher.getPortfolio());
					statement.executeUpdate();
					logger.debug("teacher has been created");
				}
			} else {
				logger.debug("user has not been created, this login already exists");
			}
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
 		}
		return true;
	}

	@Override
	public boolean update(User user) throws DaoException {

		PreparedStatement statement = null;

		try {

			connection.setAutoCommit(false);
			statement = connection.prepareStatement(SQL_UPDATE_USER);

			statement.setString(1, user.getLogin());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getRole().toString());
			statement.setInt(4, user.getId());
			statement.executeUpdate();
			close(statement);
			logger.debug("user has been updated");

			Role role = user.getRole();
			if (role == Role.CLIENT) {

				statement = connection.prepareStatement(SQL_UPDATE_CLIENT);

				Client client = (Client) user;
				statement.setString(1, client.getSurname());
				statement.setString(2, client.getName());
				statement.setString(3, client.getPatronymic());
				statement.setString(4, client.getPhone());
				statement.setString(5, client.getEmail());
				statement.setInt(6, client.getId());

				statement.executeUpdate();
				connection.commit();
			} else if (role == Role.TEACHER) {
				statement = connection.prepareStatement(SQL_UPDATE_TEACHER);
				Teacher teacher = (Teacher) user;
				statement.setString(1, teacher.getSurname());
				statement.setString(2, teacher.getName());
				statement.setString(3, teacher.getDanceStyle());
				statement.setString(4, teacher.getPortfolio());
				statement.setInt(5, teacher.getId());
				statement.executeUpdate();
				logger.debug("teacher has been updated");
			}

		} catch (SQLException e) {

			try {
				//if (connection != null) {
					connection.rollback();
				//}
			} catch (SQLException e1) {
				logger.debug("rollback error");
			}
			throw new DaoException();

		} finally {

			try {
				if (connection != null) {
					connection.setAutoCommit(true);
				}
			} catch (SQLException e1) {
				logger.debug("setAutoCommit error");

			}
			close(statement);
		}
		return true;
	}

	@Override
	public List<User> readBySurname(String surname) throws DaoException {
		
		List<User> result = new ArrayList<>();
		PreparedStatement statement = null;

		try {

			statement = connection.prepareStatement(SQL_SELECT_BY_SURNAME);
			statement.setString(1, surname);
			statement.setString(2, surname);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Role role = Role.valueOf(resultSet.getString(4));

				if (role == Role.CLIENT) {
					Client client = new Client(resultSet.getInt(1));
					client.setLogin(resultSet.getString(2));
					client.setPassword(resultSet.getString(3));
					client.setSurname(resultSet.getString(5));
					client.setName(resultSet.getString(6));
					client.setPatronymic(resultSet.getString(7));
					client.setPhone(resultSet.getString(8));
					client.setEmail(resultSet.getString(9));
					logger.debug("client has been read by surname");
					result.add(client);

				} else if (role == Role.TEACHER) {
					Teacher teacher = new Teacher(resultSet.getInt(1));
					teacher.setLogin(resultSet.getString(2));
					teacher.setPassword(resultSet.getString(3));
					teacher.setSurname(resultSet.getString(10));
					teacher.setName(resultSet.getString(11));
					teacher.setDanceStyle(resultSet.getString(12));
					teacher.setPortfolio(resultSet.getString(13));
					
					logger.debug("teacher has been read by surname");
					result.add(teacher);
				}
			}
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);
		}
		return result;
	}

	@Override
	public List<Teacher> readByDanceStyle(String danceStyle) throws DaoException {
		
		List<Teacher> result = new ArrayList<>();
		PreparedStatement statement = null;

		try {

			statement = connection.prepareStatement(SQL_SELECT_BY_DANCESTYLE);
			statement.setString(1, danceStyle);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Teacher teacher = new Teacher(resultSet.getInt(1));
				teacher.setLogin(resultSet.getString(2));
				teacher.setPassword(resultSet.getString(3));
				teacher.setName(resultSet.getString(5));
				teacher.setSurname(resultSet.getString(6));
				teacher.setDanceStyle(danceStyle);
				result.add(teacher);
			}
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);

		}
		logger.debug("teacher has been read by dancestyle");
		return result;
	}

	@Override
	public List<String> readAllDanceStyle() throws DaoException {

		List<String> result = new ArrayList<>();

		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_DANCESTYLE);

			while (resultSet.next()) {

				String dancestyle = resultSet.getString(1);
				result.add(dancestyle);
			}
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			close(statement);

		}
		logger.debug("all dancestyles have been read from db");
		return result;
	}

	@Override
	public boolean authorization(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}