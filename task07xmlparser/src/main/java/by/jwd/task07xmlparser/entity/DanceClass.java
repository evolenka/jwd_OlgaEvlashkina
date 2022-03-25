package by.jwd.task07xmlparser.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DanceClass extends Entity {

	private int id;
	private Schedule schedule;
	private Date date;

	public DanceClass() {
	}

	public DanceClass(int id, Schedule schedule, Date date) {
		this.id = id;
		this.schedule = schedule;
		this.date = date;
	}

	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "\nDanceClass [id=" + id + ", schedule=" + schedule + ", date="
				+ new SimpleDateFormat("dd.MM.yyyy").format(date) + "]";
	}
}