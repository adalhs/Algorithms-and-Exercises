package dealership;

import java.util.Scanner;

public class Dealership {

	public static void main(String[] args) {

		// Customers
		Customer cust1 = new Customer("Tom", 12000.00, "25 Cambridge St");
		Customer cust2 = new Customer("Laura", 10000.00, "103 Abbey Rd");
		Customer cust3 = new Customer("Jane", 8000.00, "131 McFarlane Rd");
		Customer cust4 = new Customer("David", 15000.00, "12 Nicholas St");

		// Vehicles
		Vehicle car1 = new Vehicle("Nissan", "Versa", "Gray", 2020, 22500.00);
		Vehicle car2 = new Vehicle("Hyundai", "Accent", "Blue", 2018, 20000.00);
		Vehicle car3 = new Vehicle("Mitsubishi", "Lancer", "White", 2016, 9500.00);

		// Employees
		Employee emp1 = new Employee("John", "E023");
		Employee emp2 = new Employee("Charlie", "E043");
		Employee emp3 = new Employee("Darleen", "E006");

		/*
		 * In these method calls, we choose which customer will be served, what car they
		 * want, which employee will take care of them, and if they will be financing
		 * the car. WE also pass in the Scanner here as an argument so that we can close
		 * it at the end of all the method calls, since we cannot reopen teh System.in
		 * stream after closing the Scanner. This way, we make sure the Scanner is
		 * available to process all customers.
		 */
		try (Scanner scanner = new Scanner(System.in)) {
			cust1.purchaseCar(car2, emp1, true, scanner);
			cust2.purchaseCar(car1, emp2, true, scanner);
			cust3.purchaseCar(car3, emp1, false, scanner);
			cust4.purchaseCar(car3, emp3, false, scanner);
		}
	}

}
