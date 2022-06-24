package by.jwd.finaltaskweb.controller;

public enum CommandEnum {

	READALLSCHEDULE, READALLTEACHER, READALLTEACHERBYADMIN, READALLGROUP, READALLMEMBERSHIPTYPES, READALLCLIENT,
	LOGINATION, REGISTRATION, TEACHERREGISTRATION, CREATEGROUP, LOGOUT, UPDATECLIENT, UPDATEPASSWORD,
	UPDATETEACHER, UPDATEGROUP, PLANNEDVISITS, MYVALIDMEMBERSHIPS, CHOOSEMEMBERSHIP, MYMEMBERSHIPSPERIOD,
	CREATEMEMBERSHIP, MYVISITS, CANCELVISIT, READGROUPBYSCHEDULE, READGROUPBYSTYLE, READGROUPBYLEVEL, READGROUPBYDATE,
	READPLANNEDCLASSESBYGROUP, CONFIRMVISIT, CREATEVISIT, READALLSTYLE, READALLWEEKDAY, READALLLEVEL,
	READAVAILIABLEDATESBYGROUP, READALLAVAILIABLEDATES, READPLANNEDCLASSESBYTEACHER, MARKPRESENCE, CANCELMARKEDPRESENCE,
	READVISITSBYGROUPANDDATE, READGROUPSBYTEACHER, READVISITCOUNTBYTEACHERGROUPSANDPERIOD, EDITCLIENT, EDITTEACHER,
	EDITGROUP, DELETECLIENT, DELETETEACHER, DELETEGROUP, WRONGCOMMAND
}