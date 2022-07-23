package oho_app_exercise;

import java.util.ArrayList;
import java.util.List;

/**
This is a class to do an exercise where given an array of customers
with different amounts of orders, I must return an array of the names
of the customers with orders over $200.  Assuming the quantity of
customers and the quantity of orders per customer is indeterminate.
(For this exercise I added 5 customers and different amounts of orders
for each customer, but the For loops work regardless of these quantities.
 */
public class Oho {
	
	//We will return the array with wanted customer names here
	public static void main(String[] args) {

		//Creating a list to put ALL customers
		List<Customer> customerList = new ArrayList<Customer>();
		
		//Creating a list to put customers with PURCHASES OVER $200
		List<String> customersOver$200 = new ArrayList<String>();
		
		//Adding customers to the list of ALL customers, notice all customers have a different amount of orders
		customerList.add(new Customer("Alice", List.of(49.99, 75.32)));
		customerList.add(new Customer("Bob", List.of(209.28, 22.92)));
		customerList.add(new Customer("John", List.of(6.99, 88.99, 305.10)));
		customerList.add(new Customer("Caroline", List.of(109.99, 8.99, 55.10)));
		customerList.add(new Customer("Steven", List.of(2.28, 279.22, 23.92, 300.00)));

		//Loop to go over all customers in the list of ALL customers one by one
		for (Customer customer : customerList) {
			
			//Loop to go over all the purchases of each customer
			for (int i = 0; i < customer.orders.size(); i++) {
				
				//If any of the customer's orders is over $200, save their name to
				//the list of customers with PURCHASES OVER $200
				if (customer.orders.get(i) > 200) {
					customersOver$200.add(customer.name);
					
					//Stops looking over the customer's purchases as soon as a purchase over $200
					//is found so their name isn't entered into the list more than once.
					break;
				}
			}
		}
		
		//Prints out the list of customers with purchases over $200
		System.out.println(customersOver$200);
	}
}
