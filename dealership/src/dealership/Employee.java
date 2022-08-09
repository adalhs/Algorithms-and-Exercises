package dealership;

import java.text.DecimalFormat;
import java.util.Scanner;

import verifiers.AddressVerifier;
import verifiers.CashOnHandVerifier;

public class Employee {

	String name;
	String empNo;

	DecimalFormat decFormat = new DecimalFormat("0.00");

	public Employee(String name, String empNo) {
		super();
		this.name = name;
		this.empNo = empNo;
	}

	public void handleCustomer(Customer cust, boolean finance, Vehicle car, Scanner scanner) {
		System.out.println("Hello " + cust.name + ", my name is " + this.name + " - (" + this.empNo
				+ ") and I'll be taking care of you.");
		if (finance == true) {
			System.out.println("I understand you are interested in financing for the " + car.year + " " + car.color
					+ " " + car.make + " " + car.model + ".\n");
			runCreditHistory(cust, car, scanner);

		} else if (car.price <= cust.cashOnHand) {
			processTransaction(cust, car);

		} else {
			System.out.println("I'm sorry " + cust.name + ", you do not have enough money to buy the " + car.year + " "
					+ car.color + " " + car.make + " " + car.model + ".\n");
		}
	}

	private void runCreditHistory(Customer cust, Vehicle car, Scanner scanner) {
		AddressVerifier.verifyAddress(cust, scanner);
		System.out.println("Ok, " + cust.address + ", got it.");

		CashOnHandVerifier.verifyCashOnHand(cust, scanner);
		System.out.println("Ok, " + cust.cashOnHand + ", got it.");

		if (cust.cashOnHand > car.price) {
			System.out.println("Hmmm, it seems you have enough money to buy the car cash.");
			processTransaction(cust, car);

		} else {
			System.out.println("Ok " + cust.name + ", the vehicle will be financed for 72 monthly installments of $"
					+ decFormat.format((car.price - cust.cashOnHand) / 72) + ".\n");
		}
	}

	private void processTransaction(Customer cust, Vehicle car) {
		System.out.println("Give me just one second to process your payment " + cust.name + "...");
		System.out.println("Enjoy your " + car.year + " " + car.color + " " + car.make + " " + car.model + ", "
				+ cust.name + "!\n");
	}
}