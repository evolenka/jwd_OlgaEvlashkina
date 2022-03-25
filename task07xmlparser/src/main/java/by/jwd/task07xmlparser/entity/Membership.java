package by.jwd.task07xmlparser.entity;

import java.util.Date;

public class Membership {

	private long id;
	private Client client;
	private String name;
	private Date startDate;
	private Date endDate;
	private int balanceClassQuantity;
	private int maxClassQuantity;
	private double price;

	public Membership() {
	}

	public Membership(long id, Client client, String name, Date startDate, Date endDate, int balanceClassQuantity,
			int maxClassQuantity, double price) {
		super();
		this.id = id;
		this.client = client;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.balanceClassQuantity = balanceClassQuantity;
		this.maxClassQuantity = maxClassQuantity;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getBalanceClassQuantity() {
		return balanceClassQuantity;
	}

	public void setBalanceClassQuantity(int balanceClassQuantity) {
		this.balanceClassQuantity = balanceClassQuantity;
	}

	public int getMaxClassQuantity() {
		return maxClassQuantity;
	}

	public void setMaxClassQuantity(int maxClassQuantity) {
		this.maxClassQuantity = maxClassQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	};

	}