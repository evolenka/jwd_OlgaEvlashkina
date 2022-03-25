package by.jwd.task07xmlparser.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Schedule {
	
	private int id;
	private WeekDay weekday;
	private Date time;
	private Group group;
	private int duration;
	
	public Schedule() {
	};
	
	public Schedule(int id, WeekDay weekday, Date time, Group group, int duration) {
		super();
		this.id = id;
		this.weekday = weekday;
		this.time = time;
		this.group = group;
		this.duration = duration;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public WeekDay getWeekDay() {
		return weekday;
	}
	public void setWeekDay(WeekDay weekday) {
		this.weekday = weekday;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duration, group, id, time, weekday);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		return duration == other.duration && Objects.equals(group, other.group) && id == other.id
				&& Objects.equals(time, other.time) && weekday == other.weekday;
	}

	@Override
	public String toString() {
		return "\nSchedule [id=" + id + ", weekday=" + weekday + ", time=" + new SimpleDateFormat("HH:mm").format(time) + ", group=" + group + ", duration="
				+ duration + "]";
	}
}
