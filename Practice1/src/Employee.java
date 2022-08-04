import java.util.Scanner;

public class Employee {

	String name;
	String empNo;

	public Employee(String name, String empNo) {
		super();
		this.name = name;
		this.empNo = empNo;
	}

	public void handleCustomer(Customer cust, boolean finance, Vehicle car) {
		if (finance = true) {
			runCreditHistory(cust, car.price - cust.cashOnHand);
		} else if (car.price <= cust.cashOnHand) {
			// processTransactionMethod(cust, car);
		} else {
			System.out.println("Not enough money");
		}
	}

	private void runCreditHistory(Customer cust, double loanAmt) {
		System.out.println("Hello " + cust.name + ", my name is " + this.name + " - (" + this.empNo
				+ ") and I'll be taking care of you.");
		
		System.out.println(cust.address);
		System.out.println(cust.cashOnHand);
		
		AddressVerifier.verifyAddress(cust);
		CashOnHandVerifier.verifyCashOnHand(cust);
		
		System.out.println(cust.address);
		System.out.println(cust.cashOnHand);

	}
}
