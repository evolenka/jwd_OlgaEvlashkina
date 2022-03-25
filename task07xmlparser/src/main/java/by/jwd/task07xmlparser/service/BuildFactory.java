package by.jwd.task07xmlparser.service;

import by.jwd.task07xmlparser.service.impl.DomParserImpl;
import by.jwd.task07xmlparser.service.impl.SaxParserImpl;
import by.jwd.task07xmlparser.service.impl.StaxParserImpl;

public class BuildFactory {

	private enum TypeParser {
		SAX, STAX, DOM
	}

	private BuildFactory() {
	}

	public static BaseBuilder createParser(String typeParser) {
		
		TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
		
		switch (type) {
		case DOM -> {
			return new DomParserImpl();
		}
		case STAX -> {
			return new StaxParserImpl();
		}
		case SAX -> {
			return new SaxParserImpl();
		}
		default -> throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
		}
	}
}
