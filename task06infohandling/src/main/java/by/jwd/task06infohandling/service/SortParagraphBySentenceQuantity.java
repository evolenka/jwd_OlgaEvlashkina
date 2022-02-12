package by.jwd.task06infohandling.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task06infohandling.entity.Delimeter;
import by.jwd.task06infohandling.entity.IComponent;

/**
 * Class SortParagraphBySentenceQuantity makes sorting of paragraphs by quantity
 * of sentences
 * 
 * @author Evlashkina
 */

public class SortParagraphBySentenceQuantity implements TextSorting {

	static Logger logger = LogManager.getLogger(SortParagraphBySentenceQuantity.class);

	/**
	 * sort paragraphs by quantity of sentences
	 *
	 * @param textComponent
	 * @return IComponent
	 */

	@Override
	public List<IComponent> sort(IComponent textComponent) {

		List<IComponent> resultList = new ArrayList<>(textComponent.getComponents());

		if (textComponent.getType() == Delimeter.TEXT) {
			resultList.sort((IComponent textComponent1, IComponent textComponent2) -> textComponent1.getSize()
					- textComponent2.getSize());

		}

		logger.debug("paragraps have been sorted by quantity of sentences");
		return resultList;
	}
}