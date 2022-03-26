package by.jwd.task07xmlparser.service;

public enum VisitXmlTag {

	VISITS("visits"), VISIT("visit"), CLIENT("client"), DANCECLASS("danceClass"), PASSWORD("password"), NAME("name"),
	SURNAME("surname"), PATRONYMIC("patronymic"), SCHEDULE("schedule"), DATE("date"), TIME("time"),
	DURATION("duration"), GROUP("group"), TITLE("title"), TEACHER("teacher"), DANCESTYLE("danceStyle");

	private String value;

	VisitXmlTag(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
