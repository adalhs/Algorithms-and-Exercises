
public class Dealership {

	public static void main(String[] args) {
		
		//Customers
		Customer cust1 = new Customer("Tom", 12000.00, "25 Cambridge St");

		//Vehicles
		Vehicle car1 = new Vehicle("Nissan", "Versa", "Gray", 2020, 22500.00);
		
		//Employees
		Employee emp1 = new Employee("John", "E023");
		
		//Method calls
		cust1.purchaseCar(car1, emp1, false);
	}

}
