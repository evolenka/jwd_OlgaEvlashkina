package by.jwd.task06infohandling.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Component;

public class CollectService {

	static Logger logger = LogManager.getLogger(CollectService.class);

	private static final CollectService instance = new CollectService();

	private CollectService() {
	}

	public static CollectService getInstance() {
		return instance;
	}

	public String collectComponent(Component composite) {
		StringBuilder text = new StringBuilder();

		switch (composite.getType()) {
		case TEXT:
			for (Component component : composite.getComponents()) {
				text.append(collectComponent(component));
				if (component != composite.getChild(composite.getSize() - 1)) {
					text.append("\r\n");
				}
			}
			break;

		case PARAGRAPH:
			for (Component component : composite.getComponents()) {
				text.append(collectComponent(component));
				if (component != composite.getChild(composite.getSize() - 1)) {
					text.append(" ");
				}
			}
			break;

		case SENTENCE:
			for (Component component : composite.getComponents()) {
				text.append(collectComponent(component));
				if (component != composite.getChild(composite.getSize() - 1)) {
					text.append(" ");
				}
			}
			break;

		case LEXEME:
			for (Component component : composite.getComponents()) {
				IsExpression check = new IsExpression();
				if (check.isBitExpression(component)) {

					Interpreter service = new Interpreter(component.toString());
					logger.debug("interpretator for bit expression has been created");

					text.append(String.valueOf(service.calculate()));
					logger.debug("calculation of bit expression has been finished");

				} else {
					text.append(collectComponent(component));
				}
			}
			break;

		case WORD:
			for (Component component : composite.getComponents()) {
				text.append(component.toString());
			}
			break;
		default:
			logger.error("wrong delimeter type");
			break;
		}
		return text.toString();
	}
}
