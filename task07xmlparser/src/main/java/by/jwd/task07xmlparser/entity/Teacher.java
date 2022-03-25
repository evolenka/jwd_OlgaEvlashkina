package by.jwd.task07xmlparser.entity;

public class Teacher extends User {

	private String danceStyle;

	public Teacher() {
		setRole(Role.TEACHER);
	}

	public Teacher(int id) {
		super(id);
		setRole(Role.TEACHER);
	}

	public String getDanceStyle() {
		return danceStyle;
	}

	public void setDanceStyle(String danceStyle) {
		this.danceStyle = danceStyle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((danceStyle == null) ? 0 : danceStyle.hashCode());
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
		Teacher other = (Teacher) obj;
		if (danceStyle == null) {
			if (other.danceStyle != null)
				return false;
		} else if (!danceStyle.equals(other.danceStyle))
			return false;

		return true;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("\nTeacher:");
		sb.append(super.toString());
		sb.append("\ndancestyle: ").append(danceStyle);
		return sb.toString();
	}
}