package by.jwd.finaltaskweb.controller;

import java.io.IOException;

import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.dao.DaoException;
import by.jwd.finaltaskweb.dao.pool.ConnectionPool;

@WebServlet("/action")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class CommandServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LogManager.getLogger(CommandServlet.class);

	@Override
	public void init() {
		try {
			ResourceBundle resourceBundle = ResourceBundle.getBundle("database");

			String driverClass = resourceBundle.getString("db.driver");
			String url = resourceBundle.getString("db.url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			int startSize = Integer.parseInt(resourceBundle.getString("startsize"));
			int maxSize = Integer.parseInt(resourceBundle.getString("maxsize"));
			int checkConnectionTimeout = Integer.parseInt(resourceBundle.getString("checkConnectionTimeout"));

			ConnectionPool.getInstance().init(driverClass, url, user, password, startSize, maxSize,
					checkConnectionTimeout);
		} catch (DaoException e) {
			logger.error("initializatin failed");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.debug("receive request");
		String page = null;
		response.setCharacterEncoding("utf8");

		HttpSession session = request.getSession(true);
		MessageManager manager = MessageManager.EN;
		if (session.getAttribute("role") == null) {
			session.setAttribute("role",  request.getParameter("role"));
		}

		// определение команды, пришедшей из JSP
		CommandProvider provider = new CommandProvider();
		Command command = provider.getCommand(request);
		logger.debug(command);

		/*
		 * вызов реализованного метода execute() и передача параметров
		 * классу-обработчику конкретной команды
		 */
		page = command.execute(request);
		logger.debug("page {}", page);

		if (page != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
			// вызов страницы ответа на запрос
			dispatcher.forward(request, response);
		} else {
			// установка страницы c cообщением об ошибке
			page = ConfigurationManager.getProperty("path.page.index");
			request.getSession().setAttribute("nullPage", manager.getProperty("nullpage"));//TO DO
			response.sendRedirect(request.getContextPath() + page);
		}
	}
}