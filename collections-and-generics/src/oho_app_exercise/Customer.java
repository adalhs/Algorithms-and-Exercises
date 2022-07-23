package oho_app_exercise;

import java.util.ArrayList;
import java.util.List;

//Creating a Customer class
public class Customer {

	//The Customer Class has two fields: The customer name and the customer's orders.
	String name;
	List<Double> orders = new ArrayList<Double>();

	//This is the Customer class' constructor method, it specifies that every Customer
	//object created MUST have a name and a list of orders.
	public Customer(String name, List<Double> orders) {
		super();
		this.name = name;
		this.orders = orders;
	}
}