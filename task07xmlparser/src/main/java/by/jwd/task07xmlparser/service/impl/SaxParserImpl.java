package by.jwd.task07xmlparser.service.impl;

import java.io.File;

import java.io.IOException;

import javax.xml.XMLConstants;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import by.jwd.task07xmlparser.service.BaseBuilder;
import by.jwd.task07xmlparser.service.ServiceException;
import by.jwd.task07xmlparser.service.VisitErrorHandler;
import by.jwd.task07xmlparser.service.VisitHandler;
import by.jwd.task07xmlparser.service.XMLValidation;

/**
 * Provides parsing of xml file by SAX parser using VisitHandler.class
 * 
 * @author Evlashkina
 * @see VisitHandler.class
 */

public class SaxParserImpl extends BaseBuilder {

	static Logger logger = LogManager.getLogger(SaxParserImpl.class);

	private static String constant = XMLConstants.W3C_XML_SCHEMA_NS_URI;

	private VisitHandler handler;
	private SchemaFactory xsdFactory;

	public SaxParserImpl() {
		handler = new VisitHandler();
		xsdFactory = SchemaFactory.newInstance(constant);
	}

	@Override
	public void buildSetVisits(String filename, String xsdFile) throws ServiceException {

		XMLValidation validation = new XMLValidation();
		validation.isValid(filename, xsdFile);

		Schema schema;
		SAXParserFactory factory = SAXParserFactory.newInstance();

		try {
			schema = xsdFactory.newSchema(new File(xsdFile));
			factory.setNamespaceAware(true);
			factory.setValidating(false);
			factory.setSchema(schema);

			SAXParser saxParser = factory.newSAXParser();
			XMLReader reader = saxParser.getXMLReader();
			reader.setErrorHandler(new VisitErrorHandler("app.log"));
			reader.setContentHandler(handler);
			reader.parse(filename);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			logger.error("error has been found while parsing xml by SAXParser");
			throw new ServiceException ();
		}

		visits = handler.getVisits();
	}
}