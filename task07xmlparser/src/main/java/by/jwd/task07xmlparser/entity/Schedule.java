package by.jwd.task07xmlparser.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	public String toString() {
		return "\nSchedule [id=" + id + ", weekday=" + weekday + ", time=" + new SimpleDateFormat("HH:mm").format(time) + ", group=" + group + ", duration="
				+ duration + "]";
	}
	

}
