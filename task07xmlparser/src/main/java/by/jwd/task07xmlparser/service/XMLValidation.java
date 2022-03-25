package by.jwd.task07xmlparser.service;

import java.io.File;
import java.io.IOException;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;


public class XMLValidation {

	static Logger logger = LogManager.getLogger(XMLValidation.class);

	public boolean isValid(String filename, String xsdFile) {
		
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(language);

		// создание схемы
		Schema schema;
		try {
			schema = factory.newSchema(new File(xsdFile));

			// создание валидатора на основе схемы
			Validator validator = schema.newValidator();
			// проверка документа
			Source source = new StreamSource(filename);
			VisitErrorHandler sh = new VisitErrorHandler("logs/app.log");
			validator.setErrorHandler(sh);
			validator.validate(source);
			return true;
		} catch (SAXException | IOException e) {
			logger.debug("xml file is not valid");
			return false;
		}
	}
}
