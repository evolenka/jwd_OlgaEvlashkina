package by.jwd.task03polymorphism.dao;

public class DaoFactory {

	private static final DaoFactory instance = new DaoFactory();

	private ReadFromJSONDao reader = new ReadFromJSONDao();
	private WriteToJSONDao writer = new WriteToJSONDao();

	private DaoFactory() {
	}

	public static DaoFactory getInstance() {
		return instance;
	}

	public ReadFromJSONDao getReader() {
		return reader;
	}

	public void setReader(ReadFromJSONDao reader) {
		this.reader = reader;
	}
	public WriteToJSONDao getWriter() {
		return writer;
	}

	public void setWriter(WriteToJSONDao writer) {
		this.writer = writer;
	}
}
