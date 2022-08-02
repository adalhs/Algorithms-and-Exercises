package oho_app_exercise;

import java.util.*;

public class Oho {
	
	public static void main(String[] args) {

		List<Customer> customers = new ArrayList<>();
		
		customers.add(new Customer("Maryanne", List.of(230.88, 21.99, 100.99)));
		customers.add(new Customer("John", List.of(100.99, 300.00, 199.99)));
		customers.add(new Customer("Will", List.of(100.99, 30.22, 100.44, 300.22)));
		customers.add(new Customer("Vanessa", List.of(100.99, 200.01, 100.44, 30000.00)));
		
		System.out.println((customersOver200(customers)));
	}
	
	public static List<String> customersOver200(List<Customer> customers){
		List<String> selectedCustomers = new ArrayList<>();
		
		//Just checking HashMap(dictionary) out
		HashMap<String, Double> custNameWithOrder = new HashMap<>();
		
		for(Customer customer : customers) {
			for(int i = 0; i < customer.orders.size(); i++) {
				if(customer.orders.get(i) > 200.00) {
					selectedCustomers.add(customer.name);
					custNameWithOrder.put(customer.name, customer.orders.get(i));
					break;
				}
			}
		}
		
		//Just checking HashMap(dictionary) out
		System.out.println(custNameWithOrder);
		
		return selectedCustomers;
	}

}
