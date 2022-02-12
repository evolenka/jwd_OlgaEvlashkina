package by.jwd.task06infohandling.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Delimeter;
import by.jwd.task06infohandling.entity.IComponent;

/**
 * Class SortLexemeByQuantityOfGivenSymbol makes sorting of lexemes in the text
 * by quantity of the given symbol or in case equality by the alphabet
 * 
 * @author Evlashkina
 */

public class SortLexemeByQuantityOfGivenSymbol implements TextSorting {

	static Logger logger = LogManager.getLogger(SortLexemeByQuantityOfGivenSymbol.class);

	private char symbol;

	public SortLexemeByQuantityOfGivenSymbol(char symbol) {
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
	public List<IComponent> sort(IComponent textComponent) {

		List<IComponent> result = new ArrayList<>();

		if (textComponent.getType() == Delimeter.TEXT) {
			result = goToTextLevel(textComponent, result);
		} else {
			result = goToParagraphLevel(textComponent, result);
		}

		logger.debug("lexemes have been collected {} ", result);

		/*
		 * use comparator to sort lexemes by quantity of the given symbol in the lexeme
		 */
		Comparator<IComponent> quantityComparator = (textComponent1, textComponent2) -> count(textComponent1)
				- count(textComponent2);
		Comparator<IComponent> stringComparator = (textComponent1, textComponent2) -> textComponent1.getChild(0)
				.toString().compareToIgnoreCase(textComponent2.getChild(0).toString());

		result.sort(quantityComparator.reversed().thenComparing(stringComparator));

		logger.debug("lexemes have been sorted {} ", result);
		return result;
	}

	/* find all lexemes in case textComponent is on the text level*/
	public List<IComponent> goToTextLevel(IComponent textComponent, List<IComponent> result) {
		logger.debug("text level");
		if (textComponent.getChild(0).getType() != Delimeter.PARAGRAPH) {
			goToParagraphLevel(textComponent, result);
		} else {
			for (IComponent text : textComponent.getComponents()) {
				IComponent paragraphComponent = text;

				for (IComponent paragraph : paragraphComponent.getComponents()) {
					IComponent sentenceComponent = paragraph;

					for (IComponent sentence : sentenceComponent.getComponents()) {
						result.add(sentence);
					}
				}

			}
		}
		logger.debug("lexemes have been found, text level");
		return result;
	}

	/* find all lexemes in case textComponent is on the paragraph level*/
	public List<IComponent> goToParagraphLevel(IComponent paragraphComponent, List<IComponent> result) {

		logger.debug("paragraph level");

		if (paragraphComponent.getChild(0).getType() != Delimeter.SENTENCE) {
			goToSentenceLevel(paragraphComponent, result);
		} else

			for (IComponent paragraph : paragraphComponent.getComponents()) {
				IComponent sentenceComponent = paragraph;

				for (IComponent sentence : sentenceComponent.getComponents()) {
					result.add(sentence);
				}
			}
		logger.debug("lexemes have been found, paragraph level");
		return result;
	}

	/* find all lexemes in case textComponent is on the sentence level */
	public List<IComponent> goToSentenceLevel(IComponent sentenceComponent, List<IComponent> result) {
		logger.debug("sentence level");
		for (IComponent sentence : sentenceComponent.getComponents()) {
			result.add(sentence);
		}
		logger.debug("lexemes have been found, sentence level");
		return result;
	}

	/* count quantity of repetitions of the given symbol in the lexeme */
	public int count(IComponent component) {
		int quantity = 0;
		for (int i = 0; i < component.toString().length(); i++) {
			if (component.toString().charAt(i) == symbol) {
				quantity++;
			}
		}
		return quantity;
	}
}