package by.jwd.task07xmlparser.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class VisitErrorHandler extends DefaultHandler {
	
	static Logger logger = LogManager.getLogger(VisitHandler.class);

	public VisitErrorHandler(String log) throws IOException {
	}

	@Override
	public void warning(SAXParseException e) {
		logger.warn(getLineColumnNumber(e) + "-" + e.getMessage());
	}

	@Override
	public void error(SAXParseException e) {
		logger.error(getLineColumnNumber(e) + " - " + e.getMessage());
	}

	@Override
	public void fatalError(SAXParseException e) {
		logger.fatal(getLineColumnNumber(e) + " - " + e.getMessage());
	}

	private String getLineColumnNumber(SAXParseException e) {
		// determine line and position of error
		return e.getLineNumber() + " : " + e.getColumnNumber();
	}
}
