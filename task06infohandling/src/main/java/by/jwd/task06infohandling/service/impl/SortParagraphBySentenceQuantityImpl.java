package by.jwd.task06infohandling.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.DelimeterType;
import by.jwd.task06infohandling.entity.Component;
import by.jwd.task06infohandling.service.TextSorting;

/**
 * Class SortParagraphBySentenceQuantity makes sorting of paragraphs by quantity
 * of sentences
 * 
 * @author Evlashkina
 */

public class SortParagraphBySentenceQuantityImpl implements TextSorting {

	static Logger logger = LogManager.getLogger(SortParagraphBySentenceQuantityImpl.class);

	/**
	 * sort paragraphs by quantity of sentences
	 *
	 * @param textComponent
	 * @return IComponent
	 */

	@Override
	public List<Component> sort(Component textComponent) {

		List<Component> resultList = new ArrayList<>(textComponent.getComponents());

		if (textComponent.getType() == DelimeterType.TEXT) {
			resultList.sort((Component textComponent1, Component textComponent2) -> textComponent1.getSize()
					- textComponent2.getSize());
		}

		logger.debug("paragraps have been sorted by quantity of sentences");
		return resultList;
	}
}