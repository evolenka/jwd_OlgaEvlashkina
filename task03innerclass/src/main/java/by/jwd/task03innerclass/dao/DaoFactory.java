package by.jwd.task03innerclass.dao;

import by.jwd.task03innerclass.dao.impl.WriteAssortmentToJSONDaoImpl;
import by.jwd.task03innerclass.dao.impl.WriteDepartmentListToJSONDaoImpl;
import by.jwd.task03innerclass.entity.Good;

public class DaoFactory {

	private static final DaoFactory instance = new DaoFactory();

	private ReadFromJSONDao reader = new ReadFromJSONDao();
	private WriteToJSONDao<Good> writeAssortment = new WriteAssortmentToJSONDaoImpl();
	private WriteToJSONDao<String> writeDepartmentList = new WriteDepartmentListToJSONDaoImpl();

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

	public WriteToJSONDao<Good> getWriteAssortment() {
		return writeAssortment;
	}

	public void setWriteAssortment(WriteToJSONDao<Good> writeAssortment) {
		this.writeAssortment = writeAssortment;
	}

	public WriteToJSONDao<String> getWriteDepartmentList() {
		return writeDepartmentList;
	}

	public void setWritewriteDepartmentList(WriteToJSONDao<String> writeDepartmentList) {
		this.writeDepartmentList = writeDepartmentList;
	}
}
