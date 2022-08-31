package com.jobready.car_dealership;

public class Dealership {

	public static void main(String[] args) {
		
		//After making the constructor don't need the setters(?)
		//Customers
		Customer cust1 = new Customer("Tom", "123 Anything St", 12000);
		Customer cust2 = new Customer("Shirley", "25 Cambridge St.", 30000);
		Customer cust3 = new Customer("Dawn", "51 Dorchester Rd.", 10000);
		
		//Vehicles
		Vehicle vehicle1 = new Vehicle("Nissan", 2020, 24000);
		Vehicle vehicle2 = new Vehicle("Hyundai", 2017, 21500);
		
		//Employees
		Employee emp1 = new Employee("Julian", 7826);
		Employee emp2 = new Employee("John", 1534);
		
		//Purchases
		cust1.purchaseCar(vehicle1, emp1, true);
		cust2.purchaseCar(vehicle2, emp2, false);
		cust3.purchaseCar(vehicle1, emp1, false);
		
		//For employee class
		//Notice I have the customer data directly assigned to variables
		//above, but in the methods I'm using .get (getters), this allows
		//for encapsulation, or "hiding" the data, we don't want users just
		//being able to change this information willingly. I.e. if they want
		//to change a customer name, they should invoke a .setCustName() method,
		//if they want to get customer's cashOnHand amount, they should
		//invoke the .getCashOnHand() method, etc.  Any time we want to
		//assign a value to an object we should use a .set method (correction, not everytime,
		//especially for setters) and anytime
		//we want to retrieve a value from an object we should use a .get method
		//This is also important because say, when a user enters a customer's address
		//we may want to process that data in a certain way, not necessarily how the
		//the user enters it, so invoking a .setCustAddress() method is a good idea.
		//To make this easier, in the Customer class, I can set those variables to
		//private, i.e:
		//	private String name;
		//	private String address;
		//  private double cashOnHand;
		//Once I set those variables to private, and if I am using them outside of
		//their class, I can hover over them and choose the option "create getter
		//and setter".  I can also do this for ALL variables by right-clicking 
		//inside a method and --> Source --> "Generate getters and setters".  Not
		//sure but I think it has to be a method INSIDE THE CLASS to whom those data
		//fields (name, address, etc.) belong and it can't be a main method.
		
		/**
		 * Must have a method called handleCustomer(Customer cust,
		 * boolean finance, Vehicle vehicle)
		 * 
		 * In the body of method, 
		 * if (finance = true):
		 * 		financeVehicle(Customer cust,
		 * 		double loanAmount(diff between cashOnHand and price of car),
		 * 		print amount financed
		 * 
		 * else if(vehicle.getPrice() <= cust.getCashOnHand()): 
		 * 		processTransaction(Customer cust, Vehicle vehicle)
		 * 		print that customer has purchased vehicle 
		 * 
		 * else:
		 * 		Tell customer to bring more money
		 * 
		 */
	}

}
