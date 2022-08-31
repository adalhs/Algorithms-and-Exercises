package com.jobready.car_dealership;

public class Customer {
	
	private String name;
	private String address;
	private double cashOnHand;
	
	public Customer(String name, String address, double cashOnHand) {
		super();
		this.name = name;
		this.address = address;
		this.cashOnHand = cashOnHand;
	}

	//boolean finance is whether the customer wants to finance the car or not
	public void purchaseCar(Vehicle vehicle, Employee emp, boolean finance) {
		emp.handleCustomer(this, vehicle, finance);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		//Say in our system we want to append this automatically
		//to each customer address
		address += " Dealership City";
		this.address = address;
	}

	public double getCashOnHand() {
		return cashOnHand;
	}

	public void setCashOnHand(double cashOnHand) {
		//Say in our system we want to give every customer a
		//$500.00 bonus
		cashOnHand += 500;
		this.cashOnHand = cashOnHand;
	}
}