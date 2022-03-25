package by.jwd.task07xmlparser.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(date, id, schedule);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DanceClass other = (DanceClass) obj;
		return Objects.equals(date, other.date) && id == other.id && Objects.equals(schedule, other.schedule);
	}

	@Override
	public String toString() {
		return "\nDanceClass [id=" + id + ", schedule=" + schedule + ", date="
				+ new SimpleDateFormat("dd.MM.yyyy").format(date) + "]";
	}
}