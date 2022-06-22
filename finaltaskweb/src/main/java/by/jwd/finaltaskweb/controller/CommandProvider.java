package by.jwd.finaltaskweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.finaltaskweb.controller.impl.CancelUpdateStatusCommandImpl;
import by.jwd.finaltaskweb.controller.impl.CancelVisitCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ChooseMembershipCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ConfirmVisitCommandImpl;
import by.jwd.finaltaskweb.controller.impl.CreateMembershipCommandImpl;
import by.jwd.finaltaskweb.controller.impl.CreateVisitCommandImpl;
import by.jwd.finaltaskweb.controller.impl.EmptyCommandImpl;
import by.jwd.finaltaskweb.controller.impl.LoginationCommandImpl;
import by.jwd.finaltaskweb.controller.impl.LogoutCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAllAvailiableDatesCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAllClientCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAllLevelCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAllMembershipTypesCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAllScheduleCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAllStyleCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAllTeacherCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAllWeekDayCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAvailiableDatesByGroupCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadGroupByDateCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadGroupByLevelCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadGroupByScheduleCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadGroupByStyleCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadGroupsByTeacherCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadMembershipByClientAndPeriodCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadPlannedClassesByTeacherCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadPlannedVisitsByClientCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadValidMembershipsByClientCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadVisitsByClientAndPeriodCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadVisitsCountByTeacherGroupsAndPeriodCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadDanceClassByGroupAndDateCommandImpl;
import by.jwd.finaltaskweb.controller.impl.RegistrationCommandImpl;
import by.jwd.finaltaskweb.controller.impl.UpdateClientCommandImpl;
import by.jwd.finaltaskweb.controller.impl.UpdatePasswordCommandImpl;
import by.jwd.finaltaskweb.controller.impl.UpdateVisitStatusCommandImpl;

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
		commands.put(CommandEnum.LOGOUT, new LogoutCommandImpl());
		commands.put(CommandEnum.UPDATECLIENT, new UpdateClientCommandImpl());
		commands.put(CommandEnum.UPDATEPASSWORD, new UpdatePasswordCommandImpl());
		commands.put(CommandEnum.PLANNEDVISITS, new ReadPlannedVisitsByClientCommandImpl());
		commands.put(CommandEnum.MYVALIDMEMBERSHIPS, new ReadValidMembershipsByClientCommandImpl());
		commands.put(CommandEnum.MYMEMBERSHIPSPERIOD, new ReadMembershipByClientAndPeriodCommandImpl());
		commands.put(CommandEnum.CREATEMEMBERSHIP, new CreateMembershipCommandImpl());
		commands.put(CommandEnum.CHOOSEMEMBERSHIP, new ChooseMembershipCommandImpl());
		commands.put(CommandEnum.MYVISITS, new ReadVisitsByClientAndPeriodCommandImpl());
		commands.put(CommandEnum.CANCELVISIT, new CancelVisitCommandImpl());
		commands.put(CommandEnum.READGROUPBYSCHEDULE, new ReadGroupByScheduleCommandImpl());
		commands.put(CommandEnum.READGROUPBYSTYLE, new ReadGroupByStyleCommandImpl());
		commands.put(CommandEnum.READGROUPBYLEVEL, new ReadGroupByLevelCommandImpl());
		commands.put(CommandEnum.READGROUPBYDATE, new ReadGroupByDateCommandImpl());
		commands.put(CommandEnum.READALLSTYLE, new ReadAllStyleCommandImpl());
		commands.put(CommandEnum.READALLLEVEL, new ReadAllLevelCommandImpl());
		commands.put(CommandEnum.READALLWEEKDAY, new ReadAllWeekDayCommandImpl());
		commands.put(CommandEnum.READAVAILIABLEDATESBYGROUP, new ReadAvailiableDatesByGroupCommandImpl());
		commands.put(CommandEnum.CREATEVISIT, new CreateVisitCommandImpl());
		commands.put(CommandEnum.CONFIRMVISIT, new ConfirmVisitCommandImpl());
		commands.put(CommandEnum.READALLAVAILIABLEDATES, new ReadAllAvailiableDatesCommandImpl());
		commands.put(CommandEnum.READPLANNEDCLASSESBYTEACHER, new ReadPlannedClassesByTeacherCommandImpl());
		commands.put(CommandEnum.MARKPRESENCE, new UpdateVisitStatusCommandImpl());
		commands.put(CommandEnum.CANCELMARKEDPRESENCE, new CancelUpdateStatusCommandImpl());
		commands.put(CommandEnum.READVISITSBYGROUPANDDATE, new ReadDanceClassByGroupAndDateCommandImpl());
		commands.put(CommandEnum.READGROUPSBYTEACHER, new ReadGroupsByTeacherCommandImpl());
		commands.put(CommandEnum.READVISITCOUNTBYTEACHERGROUPSANDPERIOD, new ReadVisitsCountByTeacherGroupsAndPeriodCommandImpl());
		commands.put(CommandEnum.WRONGCOMMAND, new EmptyCommandImpl());
	}

	public Command getCommand(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		String language = (String) session.getAttribute("language");

		logger.debug("language {}", language);

	
		
		Command command;
		// извлечение имени команды из запроса
		String action = request.getParameter("command");
		
		if(action !=null) {
	
		session.setAttribute("command", action);
		logger.debug("action {}", action);
		}
		
		if(action==null && session.getAttribute("command") != null ) {
			action = (String) session.getAttribute("command");
		}

		if (action == null || action.isEmpty()) {
			command = commands.get(CommandEnum.WRONGCOMMAND);
		} else {
			// получение объекта, соответствующего команде
			try {
				CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
				command = commands.get(currentEnum);

			} catch (IllegalArgumentException e) {
				command = commands.get(CommandEnum.WRONGCOMMAND);			
			}
		}
		return command;
	}
}
