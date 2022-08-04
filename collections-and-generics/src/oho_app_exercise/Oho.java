package oho_app_exercise;

import java.util.*;

public class Oho {
	//EXERCISE: Given a List of Customers and their orders, return an Array with the names of Customers that have an order
	//over $200.00
	
	public static void main(String[] args) {

		//Start here...
		//Creating a List of customers and adding names and dollar value of their orders
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Maryanne", List.of(230.88, 21.99, 100.99)));
		customers.add(new Customer("John", List.of(100.99, 300.00, 199.99)));
		customers.add(new Customer("Nelson", List.of(100.99, 21.87)));
		customers.add(new Customer("Will", List.of(100.99, 30.22, 100.44, 300.22)));
		customers.add(new Customer("Vanessa", List.of(100.99, 200.01, 100.44, 30000.00)));
		
		System.out.println((customersOver200(customers)));
	}
	
	public static List<String> customersOver200(List<Customer> customers){
		//This List will hold the names of the customers with an order greater than $200.00
		List<String> selectedCustomers = new ArrayList<>();
		
		//Looping over each customer's orders
		for(Customer customer : customers) {
			for(int i = 0; i < customer.orders.size(); i++) {
				
				//if any order is found over 200.00, add the customer's name to the selectedCustomers List and break out of
				//the for loop so the name isn't repeated
				if(customer.orders.get(i) > 200.00) {
					selectedCustomers.add(customer.name);
					break;
				}
			}
		}

		//returns the List with customer's names, notice Nelson isn't in the list because he does not have an order over $200.00
		return selectedCustomers;
	}

}
