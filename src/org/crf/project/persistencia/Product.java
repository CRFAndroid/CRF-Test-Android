package org.crf.project.persistencia;

public class Product {
	
	private long id;
	private String name;
	private double cost;
	private double price;
	
	public Product(String name, double cost, double price) {
		super();
		this.name = name;
		this.cost = cost;
		this.price = price;
	}
	
	public Product() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
