package by.jwd.task06infohandling.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.DelimeterType;
import by.jwd.task06infohandling.entity.Component;
import by.jwd.task06infohandling.service.TextSorting;

/**
 * Class SortLexemeByQuantityOfGivenSymbol makes sorting of lexemes in the text
 * by quantity of the given symbol or in case equality by the alphabet
 * 
 * @author Evlashkina
 */

public class SortLexemeByQuantityOfGivenSymbolImpl implements TextSorting {

	static Logger logger = LogManager.getLogger(SortLexemeByQuantityOfGivenSymbolImpl.class);

	private char symbol;

	public SortLexemeByQuantityOfGivenSymbolImpl(char symbol) {
		this.symbol = symbol;
	}

	/**
	 * sort lexemes in the text by quantity of the given symbol or in case equality
	 * by the alphabet
	 *
	 * @param text
	 * @return IComponent
	 */
	@Override
	public List<Component> sort(Component textComponent) {

		List<Component> result = new ArrayList<>();

		if (textComponent.getType() == DelimeterType.TEXT) {
			result = goToTextLevel(textComponent, result);
		} else {
			result = goToParagraphLevel(textComponent, result);
		}

		logger.debug("lexemes have been collected {} ", result);

		/*
		 * use comparator to sort lexemes by quantity of the given symbol in the lexeme
		 */
		Comparator<Component> quantityComparator = (textComponent1, textComponent2) -> count(textComponent1)
				- count(textComponent2);
		Comparator<Component> stringComparator = (textComponent1, textComponent2) -> textComponent1.getChild(0)
				.toString().compareToIgnoreCase(textComponent2.getChild(0).toString());

		result.sort(quantityComparator.reversed().thenComparing(stringComparator));

		logger.debug("lexemes have been sorted {} ", result);
		return result;
	}

	/* find all lexemes in case textComponent is on the text level*/
	public List<Component> goToTextLevel(Component textComponent, List<Component> result) {
		logger.debug("text level");
		
		if (textComponent.getChild(0).getType() != DelimeterType.PARAGRAPH) {
			goToParagraphLevel(textComponent, result);
		} else {
			for (Component text : textComponent.getComponents()) {
				Component paragraphComponent = text;

				for (Component paragraph : paragraphComponent.getComponents()) {
					Component sentenceComponent = paragraph;

					for (Component sentence : sentenceComponent.getComponents()) {
						result.add(sentence);
					}
				}

			}
		}
		logger.debug("lexemes have been found, text level");
		return result;
	}

	/* find all lexemes in case textComponent is on the paragraph level*/
	public List<Component> goToParagraphLevel(Component paragraphComponent, List<Component> result) {

		logger.debug("paragraph level");

		if (paragraphComponent.getChild(0).getType() != DelimeterType.SENTENCE) {
			goToSentenceLevel(paragraphComponent, result);
		} else

			for (Component paragraph : paragraphComponent.getComponents()) {
				Component sentenceComponent = paragraph;

				for (Component sentence : sentenceComponent.getComponents()) {
					result.add(sentence);
				}
			}
		logger.debug("lexemes have been found, paragraph level");
		return result;
	}

	/* find all lexemes in case textComponent is on the sentence level */
	public List<Component> goToSentenceLevel(Component sentenceComponent, List<Component> result) {
		logger.debug("sentence level");
		for (Component sentence : sentenceComponent.getComponents()) {
			result.add(sentence);
		}
		logger.debug("lexemes have been found, sentence level");
		return result;
	}

	/* count quantity of repetitions of the given symbol in the lexeme */
	public int count(Component component) {
		int quantity = 0;
		for (int i = 0; i < component.toString().length(); i++) {
			if (component.toString().charAt(i) == symbol) {
				quantity++;
			}
		}
		return quantity;
	}
}