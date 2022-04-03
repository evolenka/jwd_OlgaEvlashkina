package by.jwd.finaltaskweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionCommand {
	
	private static Logger logger = LogManager.getLogger(ActionCommand.class);

	public Command defineCommand(HttpServletRequest request) {

		Command current = new EmptyCommand();
// извлечение имени команды из запроса
		String action = request.getParameter("command");
		logger.debug("action {}", action);
		
		if (action == null || action.isEmpty()) {
// если команда не задана в текущем запросе
			return current;
		}
// получение объекта, соответствующего команде
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());

			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}
}