package by.jwd.task06infohandling.controller.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.controller.Command;
import by.jwd.task06infohandling.dao.DaoException;
import by.jwd.task06infohandling.dao.ReadFromFile;
import by.jwd.task06infohandling.entity.Component;
import by.jwd.task06infohandling.service.Handler;
import by.jwd.task06infohandling.service.ParserToLexeme;
import by.jwd.task06infohandling.service.ParserToParagraph;
import by.jwd.task06infohandling.service.ParserToSentence;
import by.jwd.task06infohandling.service.ParserToSymbol;
import by.jwd.task06infohandling.service.ParserToWord;
import by.jwd.task06infohandling.service.TextSorting;
import by.jwd.task06infohandling.service.impl.SortWordsByLengthImpl;
import by.jwd.task06infohandling.view.Output;

public class SortWordsByLengthCommandImpl implements Command {

	static Logger logger = LogManager.getLogger(SortWordsByLengthCommandImpl.class);

	@Override
	public void execute(String[] param) {
		try {

			Output view = new Output();

			ReadFromFile reader = new ReadFromFile();

			String textComponent = reader.read(param[0]);

			Handler parser = new ParserToParagraph(
					new ParserToSentence(new ParserToLexeme(new ParserToWord(new ParserToSymbol(null)))));

			Component component = parser.parse(textComponent);

			TextSorting service = new SortWordsByLengthImpl();
			List<Component> result = service.sort(component);

			view.print("Result of sorting words in sentences by length: ");
			view.print(result);

		} catch (DaoException e) {
			logger.error("file data not found or incorrect data");
		}
	}
}