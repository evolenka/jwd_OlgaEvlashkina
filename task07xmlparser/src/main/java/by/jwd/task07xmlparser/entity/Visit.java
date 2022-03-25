package by.jwd.task07xmlparser.entity;

import java.util.Objects;

public class Visit {
	
	private int id;
	private Client client;
	private DanceClass danceClass;
	private Status status;
	
	public Visit() {
	}
	
	public Visit(int id, Client client, DanceClass danceClass, Status status) {
		super();
		this.id = id;
		this.client = client;
		this.danceClass = danceClass;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public DanceClass getDanceClass() {
		return danceClass;
	}
	public void setDanceClass(DanceClass danceClass) {
		this.danceClass = danceClass;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(client, danceClass, id, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visit other = (Visit) obj;
		return Objects.equals(client, other.client) && Objects.equals(danceClass, other.danceClass) && id == other.id
				&& status == other.status;
	}

	@Override
	public String toString() {
		return "\nVisit [id=" + id + ", client=" + client + ", danceClass=" + danceClass + ", status=" + status + "]";
	}

}
