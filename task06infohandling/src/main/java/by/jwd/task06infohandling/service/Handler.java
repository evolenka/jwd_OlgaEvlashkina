package by.jwd.task06infohandling.service;

import by.jwd.task06infohandling.entity.Component;

public abstract class Handler {

	protected Handler nextParser;

	public abstract Component parse(String stringToParse);
}