package by.jwd.task04repository.dao;

import by.jwd.task04repository.entity.IEllipse;

public class DaoFactory {

	private static final DaoFactory instance = new DaoFactory();

	private ReadFromFile<IEllipse> readFromJson = new ReadFromJsonFileImpl();
	private ReadFromFile<String> readFromTxt = new ReadFromTxtFileImpl();

	private DaoFactory() {
	}

	public static DaoFactory getInstance() {
		return instance;
	}

	public ReadFromFile<IEllipse> getReadFromJson() {
		return readFromJson;
	}

	public void setreadFromJson(ReadFromFile<IEllipse> readFromJson) {
		this.readFromJson = readFromJson;
	}

	public ReadFromFile<String> getReadFromTxt() {
		return readFromTxt;
	}

	public void setReadFromTxt(ReadFromFile<String> readFromTxt) {
		this.readFromTxt = readFromTxt;
	}
}