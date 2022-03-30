package by.jwd.task07xmlparser.service;

import java.util.HashSet;
import java.util.Set;

import by.jwd.task07xmlparser.entity.Visit;

/**
 * Abstract class for parsing of xml file with dance studio visits data
 * 
 * @author Evlashkina
 */

public abstract class BaseBuilder {

	protected Set<Visit> visits;

	protected BaseBuilder() {
		visits = new HashSet<>();
	}

	protected BaseBuilder(Set<Visit> visits) {
		this.visits = visits;
	}

	public Set<Visit> getVisits() {
		return visits;
	}

	public abstract void buildSetVisits(String filename, String xsdFile) throws ServiceException;
}
