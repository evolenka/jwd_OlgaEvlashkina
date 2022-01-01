package by.jwd.task02array.dao;

public final class DaoFactory {

	private static final DaoFactory instance = new DaoFactory();

	private ReaderFromFileDao reader = new ReaderFromFileDao();
	

	private DaoFactory() {
	}

	public static DaoFactory getInstance() {
		return instance;
	}

	public ReaderFromFileDao getReader() {
		return reader;
	}

	public void setArrayDao(ReaderFromFileDao reader) {
		this.reader = reader;
	}
}