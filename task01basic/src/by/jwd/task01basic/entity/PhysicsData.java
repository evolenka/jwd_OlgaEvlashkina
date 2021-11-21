package by.jwd.task01basic.entity;

public class PhysicsData {
	private int boatSpeed;
	private int riverSpeed;
	private int timeAgainstStream;
	private int timeWithStream;

	public PhysicsData() {
	}

	public PhysicsData(int boatSpeed, int riverSpeed, int timeAgainstStream, int timeWithStream) {
		super();
		this.boatSpeed = boatSpeed;
		this.riverSpeed = riverSpeed;
		this.timeAgainstStream = timeAgainstStream;
		this.timeWithStream = timeWithStream;
	}

	public int getBoatSpeed() {
		return boatSpeed;
	}

	public void setBoatSpeed(int boatSpeed) {
		this.boatSpeed = boatSpeed;
	}

	public int getRiverSpeed() {
		return riverSpeed;
	}

	public void setRiverSpeed(int riverSpeed) {
		this.riverSpeed = riverSpeed;
	}

	public int getTimeAgainstStream() {
		return timeAgainstStream;
	}

	public void setTimeAgainstStream(int timeAgainstStream) {
		this.timeAgainstStream = timeAgainstStream;
	}

	public int getTimeWithStream() {
		return timeWithStream;
	}

	public void setTimeWithStream(int timeWithStream) {
		this.timeWithStream = timeWithStream;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boatSpeed;
		result = prime * result + riverSpeed;
		result = prime * result + timeAgainstStream;
		result = prime * result + timeWithStream;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhysicsData other = (PhysicsData) obj;
		if (boatSpeed != other.boatSpeed)
			return false;
		if (riverSpeed != other.riverSpeed)
			return false;
		if (timeAgainstStream != other.timeAgainstStream)
			return false;
		if (timeWithStream != other.timeWithStream)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PhysicsData [boatSpeed=" + boatSpeed + ", riverSpeed=" + riverSpeed + ", timeAgainstStream="
				+ timeAgainstStream + ", timeWithStream=" + timeWithStream + "]";
	}
}