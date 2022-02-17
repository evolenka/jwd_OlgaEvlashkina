package by.jwd.task06infohandling.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Composite;
import by.jwd.task06infohandling.entity.DelimeterType;
import by.jwd.task06infohandling.entity.Component;
import by.jwd.task06infohandling.service.TextSorting;

/**
 * Class SortWordsByLength makes sorting by length of the words in the sentence
 * 
 * 
 * @author Evlashkina
 */

public class SortWordsByLengthImpl implements TextSorting {

	static Logger logger = LogManager.getLogger(SortWordsByLengthImpl.class);

	/**
	 * sorts words in the sentence by length
	 *
	 * @param textComponent
	 * @return IComponent
	 */

	@Override
	public List<Component> sort(Component textComponent) {

		List<Component> result = new ArrayList<>();

		List<Component> sentenceList = new ArrayList<>();

		if (textComponent.getType() == DelimeterType.TEXT) {
			sentenceList = goToTextLevel(textComponent, sentenceList);
		} else {
			sentenceList = goToParagraphLevel(textComponent, sentenceList);
		}

		logger.debug("sentences have been collected {} ", sentenceList);

		/*
		 * use comparator to sort words in the sentences by length
		 */
		
		for (Component sentence : sentenceList) {
			
			List<Component> wordList = new ArrayList<>();
			
			for (Component lexeme : sentence.getComponents()) {

				wordList.add(lexeme.getChild(0));
			}

				wordList.sort(
						(Component textComponent1, Component textComponent2) -> textComponent1.getSize()
								- textComponent2.getSize());

				logger.debug("words in the sentence have been sorted by length {}", wordList);
			
				Component sortedSentence = new Composite(wordList, DelimeterType.SENTENCE);
				result.add(sortedSentence);
			
		}
		logger.debug("words in all sentences have been sorted by length {}", result);
		return result;
	}

	/* find all sentences in case textComponent is on the text level */

	public List<Component> goToTextLevel(Component textComponent, List<Component> result) {

		logger.debug("text level");

		if (textComponent.getChild(0).getType() != DelimeterType.PARAGRAPH) {
			goToParagraphLevel(textComponent, result);
		} else {
			for (Component text : textComponent.getComponents()) {
				Component paragraphComponent = text;

				for (Component paragraph : paragraphComponent.getComponents()) {
					result.add(paragraph);
				}
			}
		}
		logger.debug("sentences have been found, text level");
		return result;
	}

	/* find all sentences in case textComponent is on the paragraph level */

	public List<Component> goToParagraphLevel(Component paragraphComponent, List<Component> result) {

		logger.debug("paragraph level");

		for (Component paragraph : paragraphComponent.getComponents()) {
			result.add(paragraph);
		}

		logger.debug("sentences have been found, paragraph level");
		return result;
	}
}