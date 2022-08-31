package com.jobready.car_dealership;

import java.text.DecimalFormat;

public class Employee {
	
	private String name;
	private int empNo;
	
	DecimalFormat decFormat = new DecimalFormat("0.00");
	
	public Employee(String name, int empNo) {
		super();
		this.name = name;
		this.empNo = empNo;
	}
	
	public void handleCustomer(Customer cust, Vehicle vehicle, boolean finance) {
		if(finance == true) {  //customer needs car financed
			double loanAmount = vehicle.getPrice() - cust.getCashOnHand();
			
			System.out.println(this.getName() + " - (" + this.getEmpNo() + ") has received $" + cust.getCashOnHand() + " from " + cust.getName()
			+ " for the " + vehicle.getYear() + " " + vehicle.getModel() + ".  The remaining $" + loanAmount + " will be financed over 6"
					+ " years at $" + decFormat.format(loanAmount/72) + "/month.");
			
		}else if(vehicle.getPrice() <= cust.getCashOnHand()){  //customer has enough cashOnHand to buy the car
			processTransaction(vehicle, cust);
			
		}else { //customer is not financing, and does not have enough money to buy the car
			System.out.println(cust.getName() + " does not have enough money to buy the " + vehicle.getYear() + " " + vehicle.getModel() + ""
					+ " from " + this.getName() + " - (" + this.getEmpNo() + ").  "
					+ cust.getName() + " has $" + cust.getCashOnHand() + ", and the vehicle's cost is $" + vehicle.getPrice());
		}
	}

	public void processTransaction(Vehicle vehicle, Customer cust) {
		System.out.println(cust.getName() + " has purchased the " + vehicle.getYear() + " " + vehicle.getModel() + " for " + vehicle.getPrice()
				+ " from " + this.getName() + " - (" + this.getEmpNo() + ").  The car's new home is " + cust.getAddress() + ".");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

}
