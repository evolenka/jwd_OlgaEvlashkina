package by.jwd.task07xmlparser.entity;

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
	public String toString() {
		return "\nVisit [id=" + id + ", client=" + client + ", danceClass=" + danceClass + ", status=" + status + "]";
	}

}
