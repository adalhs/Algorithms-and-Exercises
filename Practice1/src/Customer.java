
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
	
	public void purchaseCar(Vehicle car, Employee emp, boolean finance) {
		emp.handleCustomer(this, finance, car);
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public void setCashOnHand(double cashOnHand) {
		this.cashOnHand = cashOnHand;
	}
}
