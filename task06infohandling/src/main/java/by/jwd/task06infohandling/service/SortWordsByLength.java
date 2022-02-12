package by.jwd.task06infohandling.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Delimeter;
import by.jwd.task06infohandling.entity.IComponent;

/**
 * Class SortWordsByLength makes sorting by length of the words in the sentence
 * 
 * 
 * @author Evlashkina
 */

public class SortWordsByLength implements TextSorting {

	static Logger logger = LogManager.getLogger(SortWordsByLength.class);

	/**
	 * sorts words in the sentence by length
	 *
	 * @param textComponent
	 * @return IComponent
	 */

	@Override
	public List<IComponent> sort(IComponent textComponent) {

		List<IComponent> sentenceList = new ArrayList<>();
		
		List<IComponent> result = new ArrayList<>();

		if (textComponent.getType() == Delimeter.TEXT) {
			sentenceList = goToTextLevel(textComponent, sentenceList);
		} else {
			sentenceList = goToParagraphLevel(textComponent, sentenceList);
		}

		logger.debug("sentences have been collected {} ", sentenceList);

		/*
		 * use comparator to sort words in the sentences by length
		 */
		for (IComponent sentence: sentenceList) {
			sentence.getComponents().sort((IComponent textComponent1, IComponent textComponent2) -> textComponent1.getChild(0).getSize()
							- textComponent2.getChild(0).getSize());
			result.add(sentence);
		}

		logger.debug("words in the sentences have been sorted by length {}", sentenceList);
		return result;
	}

	/* find all sentences in case textComponent is on the text level */

	public List<IComponent> goToTextLevel(IComponent textComponent, List<IComponent> result) {

		logger.debug("text level");

		if (textComponent.getChild(0).getType() != Delimeter.PARAGRAPH) {
			goToParagraphLevel(textComponent, result);
		} else {
			for (IComponent text : textComponent.getComponents()) {
				IComponent paragraphComponent = text;

				for (IComponent paragraph : paragraphComponent.getComponents()) {
					result.add(paragraph);
				}
			}
		}
		logger.debug("sentences have been found, text level");
		return result;
	}

	/* find all sentences in case textComponent is on the paragraph level */

	public List<IComponent> goToParagraphLevel(IComponent paragraphComponent, List<IComponent> result) {

		logger.debug("paragraph level");

		for (IComponent paragraph : paragraphComponent.getComponents()) {
			result.add(paragraph);
		}

		logger.debug("sentences have been found, paragraph level");
		return result;
	}
}