package by.jwd.finaltaskweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.impl.EmptyCommandImpl;
import by.jwd.finaltaskweb.controller.impl.LoginationCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAllClientCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAllMembershipTypesCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAllScheduleCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAllTeacherCommandImpl;
import by.jwd.finaltaskweb.controller.impl.RegistrationCommandImpl;

public class CommandProvider {

	private static Logger logger = LogManager.getLogger(CommandProvider.class);

	private Map<CommandEnum, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandEnum.READALLSCHEDULE, new ReadAllScheduleCommandImpl());
		commands.put(CommandEnum.READALLTEACHER, new ReadAllTeacherCommandImpl());
		commands.put(CommandEnum.READALLCLIENT, new ReadAllClientCommandImpl());
		commands.put(CommandEnum.READALLMEMBERSHIPTYPES, new ReadAllMembershipTypesCommandImpl());
		commands.put(CommandEnum.LOGINATION, new LoginationCommandImpl());
		commands.put(CommandEnum.REGISTRATION, new RegistrationCommandImpl());
		commands.put(CommandEnum.WRONGCOMMAND, new EmptyCommandImpl());
	}

	public Command getCommand(HttpServletRequest request) {
		MessageManager manager = MessageManager.EN;
		Command command;
		// извлечение имени команды из запроса
		String action = request.getParameter("command");
		logger.debug("action {}", action);

		if (action == null || action.isEmpty()) {
			// если команда не задана в текущем запросе
			command = commands.get(CommandEnum.WRONGCOMMAND);
		} else {
			// получение объекта, соответствующего команде
			try {
				CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
				command = commands.get(currentEnum);

			} catch (IllegalArgumentException e) {
				command = commands.get(CommandEnum.WRONGCOMMAND);
				request.setAttribute("wrongAction", action + manager.getProperty("message.wrongaction"));
			}
		}
		return command;
	}
}
