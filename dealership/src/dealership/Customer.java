package dealership;

import java.util.Scanner;

public class Customer {

	String name;
	double cashOnHand;
	String address;

	public Customer(String name, double cashOnHand, String address) {
		super();
		this.name = name;
		this.cashOnHand = cashOnHand;
		this.address = address;
	}

	public void purchaseCar(Vehicle car, Employee emp, boolean finance, Scanner scanner) {
		emp.handleCustomer(this, finance, car, scanner);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getCashOnHand() {
		return cashOnHand;
	}
	
	public void setCashOnHand(double cashOnHand) {
		this.cashOnHand = cashOnHand;
	}
}
