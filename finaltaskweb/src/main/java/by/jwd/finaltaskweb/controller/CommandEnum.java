package by.jwd.finaltaskweb.controller;

import by.jwd.finaltaskweb.controller.impl.ReadAllClientCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAllMembershipTypesCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAllScheduleCommandImpl;
import by.jwd.finaltaskweb.controller.impl.ReadAllTeacherCommandImpl;

public enum CommandEnum {

	READALLSCHEDULE {
		{
			this.command = new ReadAllScheduleCommandImpl();
		}
	},
	READALLTEACHER {
		{
			this.command = new ReadAllTeacherCommandImpl();
		}
	},
	READALLMEMBERSHIPTYPES {
		{
			this.command = new ReadAllMembershipTypesCommandImpl();
		}
	},

	READALLCLIENT {
		{
			this.command = new ReadAllClientCommandImpl();
		}

	};
//	READALLUSER {
//		{
//			this.command = new ReadAllUserCommandImpl();
//		}
//	};

	Command command;

	public Command getCurrentCommand() {
		return command;
	}
}
